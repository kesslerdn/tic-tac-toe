package org.kesslerdn.tictactoe.game

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.position.TestPosition
import org.kesslerdn.tictactoe.util.RowUtil

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
		first = createPosition(1)
		second = createPosition(2)
		third = createPosition(3)
		fourth = createPosition(4)
		fifth = createPosition(5)
		sixth = createPosition(6)

		positions = [first, second, third, fourth, fifth, sixth]
		rows = [[first,second,third],[fourth,fifth, sixth]]
		
		tracker = new ThreeMarkTracker(rowUtil: new RowUtil())
		board = new TicTacToeBoard(positions:positions, rows:rows)
	}
	
	@Test
	void testIsActive_FirstRow_Same(){
		first.mark = Mark.X
		second.mark = Mark.X
		third.mark = Mark.X
		
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_SecondRow_Same(){
		fourth.mark = Mark.X
		fifth.mark = Mark.X
		sixth.mark = Mark.X
		
		assert tracker.isActive(board) == false
	}
	
	@Test
	void testIsActive_FirstRow_Different(){
		first.mark = Mark.X
		second.mark = Mark.O
		third.mark = Mark.X
		
		assert tracker.isActive(board) == true
	}

	@Test
	void testIsActive_SecondRow_Different(){
		fourth.mark = Mark.X
		fifth.mark = Mark.X
		sixth.mark = Mark.O
		
		assert tracker.isActive(board) == true
	}
	
	@Test
	void testIsActive_CalculateScore_All(){
		first.mark = Mark.X
		second.mark = Mark.X
		third.mark = Mark.X
		
		assert 1 == tracker.calculateScore(Mark.X, board)
	}
	
	@Test
	void testIsActive_CalculateScore_None(){
		first.mark = Mark.X
		second.mark = Mark.X
		third.mark = Mark.X
		
		assert 0 == tracker.calculateScore(Mark.O, board)
	}
	
	@Test
	void testIsActive_CalculateScore_IncompleteRow(){
		first.mark = Mark.O
		second.mark = Mark.X
		third.mark = Mark.O
		
		assert 0 == tracker.calculateScore(Mark.O, board)
	}

	@Test
	void testIsActive_CalculateScore_TwoRows(){
		first.mark = Mark.X
		second.mark = Mark.X
		third.mark = Mark.X
		fourth.mark = Mark.X
		fifth.mark = Mark.X
		sixth.mark = Mark.X
		
		assert 2 == tracker.calculateScore(Mark.X, board)
	}

	@Test
	void testIsActive_AllDifferent(){
		assert tracker.isActive(board) == true
	}

	private Position createPosition(int index){
		TestPosition.newInstance(index)
	}
}
