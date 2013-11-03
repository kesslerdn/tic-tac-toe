package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.calculation.row.UnavailableTrialPositionCalculation
import org.kesslerdn.tictactoe.game.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil


class UnavailableTrialPositionCalculationTest extends GroovyTestCase {
	
	private UnavailableTrialPositionCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = [extractPlayerPositions:{}, extractOpposingPositions:{}] as TrialRow
	}

	@Test
	void testCalculate_ContainsBoth(){
		positionUtil = [containsBoth:{a,b -> true}] as PositionUtil
		calculation = new UnavailableTrialPositionCalculation(positionUtil: positionUtil)
		assert 0 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_ContainsOne(){
		positionUtil = [containsBoth:{a,b -> false}] as PositionUtil
		calculation = new UnavailableTrialPositionCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCompareTo(){
		assert TrialRowCalculation.BOTTOM == new UnavailableTrialPositionCalculation().compareTo(null)
	}
}
