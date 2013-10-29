package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.junit.Test

class PlayPermutationFactoryTest extends GroovyTestCase {

	@Test
	void testPermutations(){
		PermutationFactory factory = new PlayPermutationFactory()
		assert [1,2,3,4,5,6,7,8,9].permutations().size() == factory.create().size()
	}
}
