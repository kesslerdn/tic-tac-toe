package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil


class UnavailableTrailPositionCalculationTest extends GroovyTestCase {
	
	private UnavailableTrailPositionCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = [extractPlayerPositions:{}, extractOpposingPositions:{}] as TrialRow
	}

	@Test
	void testCalculate_ContainsBoth(){
		positionUtil = [containsBoth:{a,b -> true}] as PositionUtil
		calculation = new UnavailableTrailPositionCalculation(positionUtil: positionUtil)
		assert 0 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_ContainsOne(){
		positionUtil = [containsBoth:{a,b -> false}] as PositionUtil
		calculation = new UnavailableTrailPositionCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCompareTo(){
		assert ScoreCalculation.BOTTOM == new UnavailableTrailPositionCalculation().compareTo(null)
	}
}
