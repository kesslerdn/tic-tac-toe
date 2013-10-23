package org.kesslerdn.tictactoe.game;

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InOrder
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class MatchTest extends GroovyTestCase{

	static final shouldFail = new GroovyTestCase().&shouldFail
	
	static final String PLAYER_ONE = "X"
	static final String PLAYER_TWO = "O"
	static final String USER_PROMPT = 'Please select a position:'
	static final String POSITION_ONE = "1"
	static final String POSITION_TWO = "2"
	static final String POSITION_THREE = "3"
	static final String DISPLAY_OUTPUT = "display"

	@Mock
	GameControl gameControl;
	@Mock
	Tracker tracker;
	@Mock
	Board board;
	@Mock
	Turn players;

	@Test
	public void testStart() {
		
		Match match = new AlternatingMatch(gameControl: gameControl, 
			tracker: tracker, board: board, players:players)
		
		when(gameControl.request(USER_PROMPT)).thenReturn(POSITION_ONE, POSITION_TWO, POSITION_THREE)
		when(players.next()).thenReturn(PLAYER_ONE, PLAYER_TWO, PLAYER_ONE)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true, true, true, true, false)		
		
		InOrder inOrder = inOrder(gameControl, tracker, board, players)
		
		match.start();
				
		inOrder.verify(tracker, times(2)).isActive(board)
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request(USER_PROMPT)
		inOrder.verify(players).next()
		inOrder.verify(board).mark(POSITION_ONE, PLAYER_ONE)
		
		
		inOrder.verify(tracker).isActive(board)
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request(USER_PROMPT)
		inOrder.verify(players).next()
		inOrder.verify(board).mark(POSITION_TWO, PLAYER_TWO)
		
		inOrder.verify(tracker).isActive(board)
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request(USER_PROMPT)
		inOrder.verify(players).next()
		inOrder.verify(board).mark(POSITION_THREE, PLAYER_ONE)
		
		inOrder.verify(tracker).isActive(board)
		inOrder.verify(gameControl).status("Player $PLAYER_ONE won")
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		
		verifyNoMoreInteractions(tracker, gameControl, board, players)
	}
	
	@Test
	public void testStart_WithInactiveBoard() {
		
		Match match = new AlternatingMatch(gameControl: gameControl,
			tracker: tracker, board: board, players:players)
		
		when(tracker.isActive(board)).thenReturn(false)
		
		shouldFail(IllegalStateException){
			match.start();
		}
	}

}
