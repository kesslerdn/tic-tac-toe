package org.kesslerdn.tictactoe.util

import org.junit.Test
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.position.TestPosition

class RowUtilTest extends GroovyTestCase {

	@Test
	void testHasSameMark(){
		assert new RowUtil().hasSameMark([TestPosition.newInstanceX(), 
			TestPosition.newInstanceX(), TestPosition.newInstanceX()])
	}
	
	@Test
	void testHasSameMark_Different(){
		assert false == new RowUtil().hasSameMark([TestPosition.newInstanceX(),
			TestPosition.newInstanceO(), TestPosition.newInstanceX()])
	}
	
	@Test
	void testHasSameMark_AllNull(){
		assert false == new RowUtil().hasSameMark([TestPosition.newInstance(1, null),
			TestPosition.newInstance(2, null), TestPosition.newInstance(3, null)])
	}
}
