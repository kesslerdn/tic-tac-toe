package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class ScorePositionLocatorTest extends GroovyTestCase {

	@Mock PositionsLocator positionsLocator
	@Mock ScoreCalculator scoreCalculator
	@Mock Board board
	@InjectMocks PositionLocator locator = new ScorePositionLocator();
	
	@Before
	void setUp(){
		locator.markUtil = new MarkUtil()
		when(board.rows).thenReturn([[TestPosition.newInstance(1),TestPosition.newInstance(2),TestPosition.newInstance(3)],
			[TestPosition.newInstance(4),TestPosition.newInstance(5),TestPosition.newInstance(6)],
			[TestPosition.newInstance(7),TestPosition.newInstance(8),TestPosition.newInstance(9)]])
		when(positionsLocator.locate(board)).thenReturn([1,2,3])
	}
	
	@Test
	void testLocate(){
		when(scoreCalculator.calculate(anyList(), any(Position.class))).thenReturn(1,1,1, 3,3,3, 2,2,2)
		assert 2 == locator.locate(board, Mark.O)
	}
	
	@Test
	void testLocate_SameScore(){
		when(scoreCalculator.calculate(anyList(), any(Position.class))).thenReturn(1,1,1, 1,1,1, 1,1,1)
		assert 1 == locator.locate(board, Mark.O)
	}
}
