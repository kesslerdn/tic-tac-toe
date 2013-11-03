package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.calculation.row.BlockedRowCalculation;
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.TrialRow;
import org.kesslerdn.tictactoe.game.position.TestPosition
import org.kesslerdn.tictactoe.util.PositionUtil


class BlockedRowCalculationTest extends GroovyTestCase {
	
	private BlockedRowCalculation calculation
	private PositionUtil positionUtil
	private TrialRow trialRow
	private List<Position> positions
	private Position position
	
	@Before
	void setUp(){
		positions = []
		position = TestPosition.newInstanceX()
		trialRow = [extractOpenPositions:{}, getTrialPosition:{}] as TrialRow
	}

	@Test
	void testCalculate_CanBlock(){
		positionUtil = [containsIndex:{a,b -> true}] as PositionUtil
		calculation = new BlockedRowCalculation(positionUtil: positionUtil)
		assert 100 == calculation.calculate(100, trialRow)
	}

	@Test
	void testCalculate_CanNotBlock(){
		positionUtil = [containsIndex:{a,b -> false}] as PositionUtil
		calculation = new BlockedRowCalculation(positionUtil: positionUtil)
		assert 0 == calculation.calculate(100, trialRow)
	}
	
	@Test
	void testCompareTo(){
		assert TrialRowCalculation.BOTTOM == new BlockedRowCalculation().compareTo(null)
	}
}
