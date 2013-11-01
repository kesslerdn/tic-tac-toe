package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.game.Board;
import org.kesslerdn.tictactoe.game.Score;
import org.kesslerdn.tictactoe.game.Tracker;
import org.kesslerdn.tictactoe.game.player.AlternatingMatch;
import org.kesslerdn.tictactoe.game.player.Match;
import org.kesslerdn.tictactoe.game.player.Player
import org.kesslerdn.tictactoe.game.player.Turn;
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class AlternatingMatchTest extends GroovyTestCase{

	static final shouldFail = new GroovyTestCase().&shouldFail
	
	static final String DISPLAY_OUTPUT = "display"

	@Mock Tracker tracker
	@Mock Board board
	@Mock Player firstPlayer
	@Mock Player secondPlayer
	@Mock Turn players
	@Mock Score score
	@InjectMocks
	Match match = new AlternatingMatch()
	
	@Test
	void testStart() {
		when(players.next()).thenReturn(firstPlayer, secondPlayer, firstPlayer, secondPlayer)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true, true, false)		
		
		InOrder inOrder = inOrder(firstPlayer, secondPlayer, score)
		
		match.start()
				
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(score).display(board)
	}
	
	
	@Test
	void testStart_NineMoveMax() {
		when(players.next()).thenReturn(firstPlayer, secondPlayer, firstPlayer, secondPlayer, 
			firstPlayer, secondPlayer, firstPlayer, secondPlayer,
			firstPlayer, secondPlayer)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(tracker.isActive(board)).thenReturn(true)
		
		InOrder inOrder = inOrder(firstPlayer, secondPlayer, score)
		
		match.start()
				
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(secondPlayer).play(board)
		inOrder.verify(firstPlayer).play(board)
		inOrder.verify(score).display(board)
	}

}
