package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.PositionLocator
import org.kesslerdn.tictactoe.game.position.TestPosition
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil

class ScorePositionLocatorTest {

	private Board board
	private ScoreCalculator scoreCalculator
	private PositionLocator locator
	private MarkUtil markUtil
	private PositionUtil positionUtil
	private TrialPositionFactory trialPositionFactory
	private Mark mark 
	private Mark opposingMark 
	private int position 
	private List<Integer> openPositions 
	private List<Integer> row 
	private List<List<Integer>> rows 
	private List<Position> positions 
	private Position trialPosition 
	private int trialPositionIndex

	
	@Before
	void setUp(){
		Mark mark = Mark.O
		Mark opposingMark = Mark.X
		int position = 1
		List<Integer> openPositions = [position]
		List<Integer> rowOne = [1]
		List<Integer> rowTwo = [2]
		List<List<Integer>> rows = [rowOne, rowTwo]
		List<Position> positions = [TestPosition.newInstance(1, null)]
		trialPositionIndex = 10
		trialPosition = new TrialPosition(index:trialPositionIndex)
		
		scoreCalculator = [calculate:{a,b -> position}] as ScoreCalculator
		positionUtil = [openPositions:{a -> openPositions}] as PositionUtil
		trialPositionFactory = [create: {a, b -> trialPosition}] as TrialPositionFactory
		board = [getRows:{rows}, getPositions:{positions}] as Board
		markUtil = [retrieveOpponentMark: {a -> opposingMark}] as MarkUtil

		locator = new ScorePositionLocator(scoreCalculator:scoreCalculator, markUtil:markUtil, 
			positionUtil:positionUtil, trialPositionFactory:trialPositionFactory)
	}
	
	@Test
	void testLocate_OnePosition(){		
		assert trialPositionIndex == locator.locate(board, mark)
	}
	
	@Test
	void testLocate_TwoOpenAndOppositePositions_WithEvenTrailPosition(){		
		trialPosition = new TrialPosition(index:2)
		List<Position> positions = [TestPosition.newInstanceX(3), TestPosition.newInstanceX(7)]
		assert 2 == locator.locate(board, mark)
	}
}
