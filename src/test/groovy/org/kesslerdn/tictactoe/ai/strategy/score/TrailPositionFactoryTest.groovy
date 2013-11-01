package org.kesslerdn.tictactoe.ai.strategy.score

import org.junit.Test
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position

class TrailPositionFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		Position trialPosition = new TrialPositionFactory().create(1, Mark.O)
		assertNotNull(trialPosition)
		assert 1 == trialPosition.index
		assert Mark.O == trialPosition.mark
	}
}
