package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.TicTacToeBoard
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class ScorePositionLocatorTest extends GroovyTestCase {

	Board board
	@Mock ScoreCalculator scoreCalculator
	@InjectMocks PositionLocator locator = new ScorePositionLocator()
	
	@Before
	void setUp(){
		locator.markUtil = new MarkUtil()
		locator.positionUtil = new PositionUtil()
	}
	
	@Test
	void testLocate(){
		board = new TicTacToeBoard(positions:[TestPosition.newInstance(1, Mark.O),TestPosition.newInstance(2, null),TestPosition.newInstance(3, null)])
		when(scoreCalculator.calculate(anyList(), any(Position.class))).thenReturn(1,1,1, 3,3,3, 2,2,2)
		assert 2 == locator.locate(board, Mark.O)
	}
	
	@Test
	void testLocate_SameScore(){
		board = new TicTacToeBoard(positions:[TestPosition.newInstance(1, null),TestPosition.newInstance(2, null),TestPosition.newInstance(3, null)])
		when(scoreCalculator.calculate(anyList(), any(Position.class))).thenReturn(1,1,1, 1,1,1, 1,1,1)
		assert 1 == locator.locate(board, Mark.O)
	}
}
