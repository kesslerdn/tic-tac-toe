package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil


class OpponentSelecteRowCalculationTest extends GroovyTestCase {
	
	private OpponentSelecteRowCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = [extractPlayerPositions:{}, extractOpposingPositions:{}] as TrialRow
	}

	@Test
	void testCalculate(){
		positionUtil = [containsOnlyOpponenet:{a,b -> true}] as PositionUtil
		calculation = new OpponentSelecteRowCalculation(positionUtil: positionUtil)
		assert 105 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_CanNotBlock(){
		positionUtil = [containsOnlyOpponenet:{a,b -> false}] as PositionUtil
		calculation = new OpponentSelecteRowCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}
	
	@Test
	void testCompareTo(){
		assert ScoreCalculation.TOP == new OpponentSelecteRowCalculation().compareTo(null)
	}
}
