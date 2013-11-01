package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil


class OppositeBoardStrategyCalculationTest extends GroovyTestCase {
	
	private OppositeBoardStrategyCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = [getTrialPosition:{}, extractOpposingPositions:{}] as TrialRow
	}

	@Test
	void testCalculate_HasMoreEvens_AndIsOdd(){
		positionUtil = [hasMoreEvens:{a -> true}, 
			isOdd:{a -> true}] as PositionUtil
		calculation = new OppositeBoardStrategyCalculation(positionUtil: positionUtil)
		assert 105 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_HasMoreOdds_AndIsEven(){
		positionUtil = [hasMoreEvens:{a -> false}, 
			isOdd:{a -> false},
			hasMoreOdds:{a -> true}, 
			isEven:{a -> true}] as PositionUtil
		calculation = new OppositeBoardStrategyCalculation(positionUtil: positionUtil)
		assert 105 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_HasMoreEvens_AndIsEven(){
		positionUtil = [hasMoreEvens:{a -> true}, 
			isOdd:{a -> false},
			hasMoreOdds:{a -> false}, 
			isEven:{a -> false}] as PositionUtil
		calculation = new OppositeBoardStrategyCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_HasMoreOdds_AndIsOdd(){
		positionUtil = [hasMoreEvens:{a -> false}, 
			isOdd:{a -> false},
			hasMoreOdds:{a -> true}, 
			isEven:{a -> false}] as PositionUtil
		calculation = new OppositeBoardStrategyCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}
	
	@Test
	void testCompareTo(){
		assert ScoreCalculation.TOP == new OppositeBoardStrategyCalculation().compareTo(null)
	}
}
