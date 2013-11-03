package org.kesslerdn.tictactoe.game

import org.junit.Test
import org.kesslerdn.tictactoe.game.TrialPosition;


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
