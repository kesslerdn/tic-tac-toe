package org.kesslerdn.tictactoe.ai.strategy.score

import org.junit.Test
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position

class TrialPositionFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		List<Position> trialPositions = new TrialPositionFactory().create([1,2], Mark.O)
		assertNotNull(trialPositions)
		assert 2 == trialPositions.size()
		assert 1 == trialPositions[0].index
		assert Mark.O == trialPositions[0].mark
		assert 2 == trialPositions[1].index
		assert Mark.O == trialPositions[1].mark
	}
}
