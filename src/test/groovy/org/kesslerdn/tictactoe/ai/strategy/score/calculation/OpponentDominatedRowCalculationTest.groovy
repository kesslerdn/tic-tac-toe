package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import static org.junit.Assert.*

import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow


class OpponentDominatedRowCalculationTest extends GroovyTestCase {
	
	private OpponentDominatedRowCalculation calculation
	private TrialRow trialRow

	@Test
	void testCalculate_HasOpposingPositions(){
		trialRow = [extractOpposingPositions:{[null, null]}] as TrialRow
		calculation = new OpponentDominatedRowCalculation()
		assert 100000 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_NoOpposingPositions(){
		trialRow = [extractOpposingPositions:{[null]}] as TrialRow
		calculation = new OpponentDominatedRowCalculation()
		assert 100 == calculation.calculate(100, trialRow)
	}
	
	@Test
	void testCompareTo(){
		assert ScoreCalculation.TOP == new OpponentDominatedRowCalculation().compareTo(null)
	}
}
