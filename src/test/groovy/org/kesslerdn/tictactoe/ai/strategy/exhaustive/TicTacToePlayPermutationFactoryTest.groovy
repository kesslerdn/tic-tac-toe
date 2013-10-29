package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.junit.Test

class TicTacToePlayPermutationFactoryTest extends GroovyTestCase {

	@Test
	void testPermutations(){
		PermutationFactory factory = new TicTacToePlayPermutationFactory()
		assert [1,2,3,4,5,6,7,8,9].permutations().size() == factory.create().size()
	}
}
