package org.kesslerdn.tictactoe.ai.strategy.score.calculation.board

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.TrialPosition;
import org.kesslerdn.tictactoe.game.position.TestPosition
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil

class OppositeCornerCalculationTest extends GroovyTestCase {
	
	private Mark mark = Mark.O
	private Mark opposingMark = Mark.X
	private Board board
	private OppositeCornerCalculation calculation
	private MarkUtil markUtil
	private PositionUtil positionUtil

	@Before
	void setUp(){
		positionUtil = [areOppositeCornersMarked:{a,b -> true},
			isEven:{a -> true}] as PositionUtil
		markUtil = [retrieveOpponentMark:{mark}] as MarkUtil
		board = [getPositions: {[TestPosition.newInstanceO(), TestPosition.newInstanceO()]}] as Board
	}
	
	@Test
	void testCalculate(){
		calculation = new OppositeCornerCalculation(positionUtil:positionUtil, markUtil:markUtil)
		
		assert 10 == calculation.calculate(0, board, new TrialPosition(mark:opposingMark))
	}
	
	@Test
	void testCalculate_TwoOpposingPositions_OddTrialPosition(){
		positionUtil = [areOppositeCornersMarked:{a,b -> true},
									isEven:{a -> false}] as PositionUtil
		calculation = new OppositeCornerCalculation(positionUtil:positionUtil, markUtil:markUtil)
		
		assert 0 == calculation.calculate(0, board, new TrialPosition(mark:opposingMark))
	}

	@Test
	void testCalculate_TwoOpposingPositions_AreNotOpposite(){
		positionUtil = [areOppositeCornersMarked:{a,b -> false},
									isEven:{a -> true}] as PositionUtil
		calculation = new OppositeCornerCalculation(positionUtil:positionUtil, markUtil:markUtil)
		
		assert 0 == calculation.calculate(0, board, new TrialPosition(mark:opposingMark))
	}

	@Test
	void testCalculate_LessThanTwoOpposingPositions(){
		board = [getPositions: {[TestPosition.newInstanceO()]}] as Board
		calculation = new OppositeCornerCalculation(positionUtil:positionUtil, markUtil:markUtil)
		
		assert 0 == calculation.calculate(0, board, new TrialPosition(mark:opposingMark))
	}
	
	@Test
	void testCalculate_MoreThanTwoOpposingPositions(){
		board = [getPositions: {[TestPosition.newInstanceO(), TestPosition.newInstanceO(), TestPosition.newInstanceO()]}] as Board
		calculation = new OppositeCornerCalculation(positionUtil:positionUtil, markUtil:markUtil)
		
		assert 0 == calculation.calculate(0, board, new TrialPosition(mark:opposingMark))
	}

	@Test
	void testCompareTo(){
		assert ScoreCalculation.TOP == new OppositeCornerCalculation().compareTo(null)
	}
}
