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
	
	@Test
	void testFindMark(){
		assert 2 == util.findMark(
			[TestPosition.newInstance(1, Mark.X), TestPosition.newInstance(2, Mark.O), TestPosition.newInstance(3, Mark.X)], 
			Mark.X).size()
	}
	
	@Test
	void testFindMark_None(){
		assert 0 == util.findMark(
			[TestPosition.newInstance(1, Mark.O), TestPosition.newInstance(2, Mark.O), TestPosition.newInstance(3, Mark.O)], 
			Mark.X).size()
	}
	
	@Test
	void testContainsOnlyOpponenet(){
		assert util.containsOnlyOpponenet([], [TestPosition.newInstance(1, Mark.O)])
	}
	
	@Test
	void testContainsOnlyOpponenet_False_HasBoth(){
		assert false == util.containsOnlyOpponenet([TestPosition.newInstance(1, Mark.O)], [TestPosition.newInstance(1, Mark.O)])
	}
	
	@Test
	void testContainsOnlyOpponenet_False_NoOpponentPositions(){
		assert false == util.containsOnlyOpponenet([TestPosition.newInstance(1, Mark.O)], [])
	}
	
	@Test
	void testContainsOnlyOpponenet_False_Neither(){
		assert false == util.containsOnlyOpponenet([], [])
	}
	
	@Test
	void testContainsBoth_False_OnlyOpponent(){
		assert false == util.containsBoth([], [TestPosition.newInstance(1, Mark.O)])
	}
	
	@Test
	void testContainsBoth_False_HasBoth(){
		assert util.containsBoth([TestPosition.newInstance(1, Mark.O)], [TestPosition.newInstance(1, Mark.O)])
	}
	
	@Test
	void testContainsOnlyOpponenet_False_OnlyPlayer(){
		assert false == util.containsBoth([TestPosition.newInstance(1, Mark.O)], [])
	}
	
	@Test
	void testContainsBoth_False_Neither(){
		assert false == util.containsBoth([], [])
	}
	
	@Test
	void testHasMoreEvens(){
		assert util.hasMoreEvens([TestPosition.newInstance(2), TestPosition.newInstance(1), TestPosition.newInstance(4)])
	}
	
	@Test
	void testHasMoreEvens_False(){
		assert false == util.hasMoreEvens([TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3)])
	}
	
	@Test
	void testHasMoreEvens_False_None(){
		assert false == util.hasMoreEvens([])
	}
	
	@Test
	void testHasMoreOdds(){
		assert util.hasMoreOdds([TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3)])
	}
	
	@Test
	void testHasMoreOdds_False(){
		assert false == util.hasMoreOdds([TestPosition.newInstance(2), TestPosition.newInstance(3), TestPosition.newInstance(4)])
	}
	
	@Test
	void testHasMoreOdds_False_None(){
		assert false == util.hasMoreOdds([])
	}
	
	@Test
	void testContainsIndex(){
		assert util.containsIndex([TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3)], 
			TestPosition.newInstance(2))
	}
	
	@Test
	void testContainsIndex_False(){
		assert false == util.containsIndex([TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3)], 
			TestPosition.newInstance(4))
	}
	
	@Test
	void testIsFirstTurnWithCenterPositionOpen(){
		assert util.isFirstTurnWithCenterPositionOpen([], [TestPosition.newInstance(1, Mark.O)], 
			TestPosition.newInstance(5))
	}
	
	@Test
	void testIsFirstTurnWithCenterPositionOpen_TrialPositionNot5(){
		assert false == util.isFirstTurnWithCenterPositionOpen([], [TestPosition.newInstance(1, Mark.O)], 
			TestPosition.newInstance(1))
	}
	
	@Test
	void testIsFirstTurnWithCenterPositionOpen_OpponentAlreadyMarked5(){
		assert false == util.isFirstTurnWithCenterPositionOpen([], [TestPosition.newInstance(5, Mark.O)], 
			TestPosition.newInstance(5))
	}
		
	@Test
	void testIsFirstTurnWithCenterPositionTaken(){
		assert util.isFirstTurnWithCenterPositionTaken([], [TestPosition.newInstance(5, Mark.O)],
			TestPosition.newInstance(3))
	}
	
	@Test
	void testIsFirstTurnWithCenterPositionTaken_TrialPositionNot3(){
		assert false == util.isFirstTurnWithCenterPositionTaken([], [TestPosition.newInstance(5, Mark.O)],
			TestPosition.newInstance(1))
	}
	
	@Test
	void testIsFirstTurnWithCenterPositionTaken_OpponentNotMarked5(){
		assert false == util.isFirstTurnWithCenterPositionTaken([], [TestPosition.newInstance(1, Mark.O)],
			TestPosition.newInstance(3))
	}
}
