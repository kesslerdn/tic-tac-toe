package org.kesslerdn.tictactoe.util

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark

class PositionAnalysisUtilTest extends GroovyTestCase{
	PositionAnaylysisUtil util
	
	@Before
	void setUp(){
		util = new PositionAnaylysisUtil()
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
}
