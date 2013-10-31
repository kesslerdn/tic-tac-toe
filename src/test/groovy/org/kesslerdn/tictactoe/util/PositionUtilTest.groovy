package org.kesslerdn.tictactoe.util

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark

class PositionUtilTest extends GroovyTestCase{
	PositionUtil util
	
	@Before
	void setUp(){
		util = new PositionUtil()
	}
	
	@Test
	void testAreOppositeCornersMarked_OneAndNine_True(){
		assert util.areOppositeCornersMarked(
			[TestPosition.newInstance(1, Mark.X), TestPosition.newInstance(9, Mark.X)], 
			Mark.X)
	}
	
	@Test
	void testAreOppositeCornersMarked_ThreeAndSeven_True(){
		assert util.areOppositeCornersMarked(
			[TestPosition.newInstance(3, Mark.X), TestPosition.newInstance(7, Mark.X)],
			Mark.X)
	}
	
	@Test
	void testAreOppositeCornersMarked_NotOppositeCorners(){
		assert false == util.areOppositeCornersMarked(
			[TestPosition.newInstance(3, Mark.X), TestPosition.newInstance(9, Mark.X)],
			Mark.X)
	}

	@Test
	void testAreOppositeCornersMarked_OneAndNine_False_WrongMark(){
		assert false == util.areOppositeCornersMarked(
			[TestPosition.newInstance(1, Mark.O), TestPosition.newInstance(9, Mark.O)], 
			Mark.X)
	}
	
	@Test
	void testIsEven(){
		assert util.isEven(TestPosition.newInstance(2))
	}
	
	@Test
	void testIsEven_False(){
		assert false == util.isEven(TestPosition.newInstance(1))
	}
	
	@Test
	void testIsOdd(){
		assert util.isOdd(TestPosition.newInstance(1))
	}
	
	@Test
	void testIsOdd_False(){
		assert false == util.isOdd(TestPosition.newInstance(2))
	}
	
	@Test
	void testEvenCount(){
		assert 2 == util.evenCount([TestPosition.newInstance(2), TestPosition.newInstance(1), TestPosition.newInstance(4)])
	}
	
	@Test
	void testEvenCount_Zero(){
		assert 0 == util.evenCount([TestPosition.newInstance(1)])
	}
	
	@Test
	void testOddCount(){
		assert 2 == util.oddCount([TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3)])
	}
	
	@Test
	void testOddCount_Zero(){
		assert 0 == util.oddCount([TestPosition.newInstance(2)])
	}
}
