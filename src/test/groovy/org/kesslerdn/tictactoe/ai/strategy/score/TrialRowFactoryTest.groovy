package org.kesslerdn.tictactoe.ai.strategy.score

import org.junit.Test

class TrialRowFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		TrialRow trialRow = new TrialRowFactory().create([], null)
		assertNotNull(trialRow)
	}
}
