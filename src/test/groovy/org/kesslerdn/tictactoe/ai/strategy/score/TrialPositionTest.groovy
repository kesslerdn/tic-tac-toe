package org.kesslerdn.tictactoe.ai.strategy.score

import org.junit.Test


class TrialPositionTest extends GroovyTestCase {
	
	@Test(expected=IllegalAccessException.class)
	void testWrite_ThrowsException(){
		try{
			new TrialPosition().write()
			fail
		}catch(IllegalAccessException e){
			assertNotNull(e)
		}
	}
}
