package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.calculation.row.OpponentSelectedRowCalculation;
import org.kesslerdn.tictactoe.game.TrialRow;
import org.kesslerdn.tictactoe.util.PositionUtil


class OpponentSelectedRowCalculationTest extends GroovyTestCase {
	
	private OpponentSelectedRowCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = [extractPlayerPositions:{}, extractOpposingPositions:{}] as TrialRow
	}

	@Test
	void testCalculate(){
		positionUtil = [containsOnlyOpponenet:{a,b -> true}] as PositionUtil
		calculation = new OpponentSelectedRowCalculation(positionUtil: positionUtil)
		assert 105 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_CanNotBlock(){
		positionUtil = [containsOnlyOpponenet:{a,b -> false}] as PositionUtil
		calculation = new OpponentSelectedRowCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}
	
	@Test
	void testCompareTo(){
		assert TrialRowCalculation.TOP == new OpponentSelectedRowCalculation().compareTo(null)
	}
}
