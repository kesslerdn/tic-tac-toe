package org.kesslerdn.tictactoe.game

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.game.Board;
import org.kesslerdn.tictactoe.game.FinalScore;
import org.kesslerdn.tictactoe.game.Mark;
import org.kesslerdn.tictactoe.game.Tracker
import org.kesslerdn.tictactoe.view.GameControl;
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class FinalScoreTest extends GroovyTestCase{

	static final String DISPLAY_OUTPUT = "display"
	@Mock GameControl gameControl
	@Mock Tracker tracker
	@Mock Board board
	@InjectMocks
	Score score = new FinalScore()

	@Test
	void testDisplay_Tie() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(1)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("This game ended in a tie!")
	}

	@Test
	void testDisplay_PlayerOneWins() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(1)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(0)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player '$Mark.X' won!")
	}

	@Test
	void testDisplay_PlayerTwoWins() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(0)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player '$Mark.O' won!")
	}

	@Test
	void testHasWinner_Tie() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(1)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert !score.hasWinner(board)
	}

	@Test
	void testHasWinner_PlayerOneWins() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(1)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(0)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert score.hasWinner(board)
	}

	@Test
	void testHasWinner_PlayerTwoWins() {
		when(tracker.calculateScore(Mark.X, board)).thenReturn(0)
		when(tracker.calculateScore(Mark.O, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert score.hasWinner(board)
	}
}
