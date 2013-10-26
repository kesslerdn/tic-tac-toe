package org.kesslerdn.tictactoe.game

import org.junit.Before;
import org.junit.Test
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.TicTacToeBoard
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition;

class ThreeMarkTrackerTest extends GroovyTestCase {
	private List<Position> positions
	private List<List<Position>> rows
	private Tracker tracker
	private Board board
	private Position first
	private Position second
	private Position third
	private Position fourth
	private Position fifth
	private Position sixth
	private Position seventh
	private Position eighth
	private Position nineth
	
	@Before
	void setUp(){
		first = createPosition("1")
		second = createPosition("2")
		third = createPosition("3")
		fourth = createPosition("4")
		fifth = createPosition("5")
		sixth = createPosition("6")

		positions = [first, second, third, fourth, fifth, sixth]
		rows = [[first,second,third],[fourth,fifth, sixth]]
		
		tracker = new ThreeMarkTracker()
		board = new TicTacToeBoard(positions:positions, rows:rows)
	}
	
	@Test
	void testIsActive_FirstRow_Same(){
		first.value = "A"
		second.value = "A"
		third.value = "A"
		
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_SecondRow_Same(){
		fourth.value = "A"
		fifth.value = "A"
		sixth.value = "A"
		
		assert tracker.isActive(board) == false
	}
	
	@Test
	void testIsActive_FirstRow_Different(){
		first.value = "A"
		second.value = "B"
		third.value = "A"
		
		assert tracker.isActive(board) == true
	}

	@Test
	void testIsActive_SecondRow_Different(){
		fourth.value = "A"
		fifth.value = "A"
		sixth.value = "B"
		
		assert tracker.isActive(board) == true
	}
	
	@Test
	void testIsActive_CalculateScore_All(){
		first.value = "A"
		second.value = "A"
		third.value = "A"
		
		assert 1 == tracker.calculateScore("A", board)
	}
	
	@Test
	void testIsActive_CalculateScore_None(){
		first.value = "A"
		second.value = "A"
		third.value = "A"
		
		assert 0 == tracker.calculateScore("B", board)
	}
	
	@Test
	void testIsActive_CalculateScore_IncompleteRow(){
		first.value = "B"
		second.value = "A"
		third.value = "B"
		
		assert 0 == tracker.calculateScore("B", board)
	}

	@Test
	void testIsActive_CalculateScore_TwoRows(){
		first.value = "A"
		second.value = "A"
		third.value = "A"
		fourth.value = "A"
		fifth.value = "A"
		sixth.value = "A"
		
		assert 2 == tracker.calculateScore("A", board)
	}

	@Test
	void testIsActive_AllDifferent(){
		assert tracker.isActive(board) == true
	}

	private Position createPosition(String value){
		new TestPosition(value)
	}
}
