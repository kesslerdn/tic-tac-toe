package org.kesslerdn.tictactoe.view;

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.Tracker
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class FinalScoreTest extends GroovyTestCase{

	static final String DISPLAY_OUTPUT = "display"
	static final String FIRST_MARK = "A"
	static final String SECOND_MARK = "B"
	@Mock GameControl gameControl
	@Mock Tracker tracker
	@Mock Board board
	@InjectMocks
	Score score = new FinalScore(firstMark:FIRST_MARK, secondMark:SECOND_MARK)

	@Test
	public void testDisplay_Tie() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(1)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("This game ended in a tie!")
	}

	@Test
	public void testDisplay_PlayerOneWins() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(1)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(0)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player '$FIRST_MARK' won!")
	}

	@Test
	public void testDisplay_PlayerTwoWins() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(0)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		score.display(board)

		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).status("Player '$SECOND_MARK' won!")
	}

	@Test
	public void testHasWinner_Tie() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(1)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert !score.hasWinner(board)
	}

	@Test
	public void testHasWinner_PlayerOneWins() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(1)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(0)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert score.hasWinner(board)
	}

	@Test
	public void testHasWinner_PlayerTwoWins() {
		when(tracker.calculateScore(FIRST_MARK, board)).thenReturn(0)
		when(tracker.calculateScore(SECOND_MARK, board)).thenReturn(1)
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		
		InOrder inOrder = inOrder(gameControl)

		assert score.hasWinner(board)
	}
}
