package org.kesslerdn.tictactoe.ai.strategy.score;

import org.junit.Test

public class TrailRowFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		TrialRow trialRow = new TrialRowFactory().create([], null)
		assertNotNull(trialRow)
	}
}
