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
		when(players.next()).thenReturn(firstPlayer, secondPlayer, firstPlayer, secondPlayer)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true, true, false)		
		
		InOrder inOrder = inOrder(firstPlayer, secondPlayer, gameControl)
		
		match.start();
				
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player ?? won")
	}
	
	@Test
	public void testStart_Tie() {
		when(firstPlayer.mark).thenReturn(MARK_ONE)
		when(players.next()).thenReturn(firstPlayer, secondPlayer, firstPlayer, secondPlayer)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true, true, false)
		
		InOrder inOrder = inOrder(firstPlayer, secondPlayer, gameControl)
		
		match.start();
				
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player ?? won")
	}
}
