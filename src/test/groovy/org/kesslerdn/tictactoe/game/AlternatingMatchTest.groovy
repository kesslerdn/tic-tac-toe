package org.kesslerdn.tictactoe.game;

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Player
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class AlternatingMatchTest extends GroovyTestCase{

	static final shouldFail = new GroovyTestCase().&shouldFail
	
	static final String MARK_ONE = "X"
	static final String MARK_TWO = "O"
	static final String USER_PROMPT = 'please select a position'
	static final String POSITION_ONE = "1"
	static final String POSITION_TWO = "2"
	static final String POSITION_THREE = "3"
	static final String DISPLAY_OUTPUT = "display"

	@Mock GameControl gameControl;
	@Mock Tracker tracker;
	@Mock Board board;
	@Mock Player firstPlayer
	@Mock Player secondPlayer
	@Mock Turn players;
	@InjectMocks
	Match match = new AlternatingMatch()
	
	@Test
	public void testStart() {
		when(firstPlayer.mark).thenReturn(MARK_ONE)
		when(secondPlayer.mark).thenReturn(MARK_TWO)
		when(gameControl.request(anyString())).thenReturn(POSITION_ONE, POSITION_TWO, POSITION_THREE)
		when(players.next()).thenReturn(firstPlayer, secondPlayer, firstPlayer)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true, true, true, true, false)		
		
		InOrder inOrder = inOrder(gameControl, board)
		
		match.start();
				
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK_ONE $USER_PROMPT")
		inOrder.verify(board).mark(POSITION_ONE, MARK_ONE)
		
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK_TWO $USER_PROMPT")
		inOrder.verify(board).mark(POSITION_TWO, MARK_TWO)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK_ONE $USER_PROMPT")
		inOrder.verify(board).mark(POSITION_THREE, MARK_ONE)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player $MARK_ONE won")
		
		verifyNoMoreInteractions(gameControl, board)
	}
	
	@Test
	public void testStart_WithInactiveBoard() {
		when(tracker.isActive(board)).thenReturn(false)
		
		shouldFail(IllegalStateException){
			match.start();
		}
	}

}
