package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import static org.junit.Assert.*

import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.calculation.row.OpponentDominatedRowCalculation
import org.kesslerdn.tictactoe.game.TrialRow


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
		assert TrialRowCalculation.TOP == new OpponentDominatedRowCalculation().compareTo(null)
	}
}
