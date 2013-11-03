package org.kesslerdn.tictactoe.game

import org.junit.Test
import org.kesslerdn.tictactoe.game.TrialRow;
import org.kesslerdn.tictactoe.game.TrialRowFactory;

class TrialRowFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		TrialRow trialRow = new TrialRowFactory().create([], null)
		assertNotNull(trialRow)
	}
}
