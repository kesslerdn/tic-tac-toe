package org.kesslerdn.tictactoe.game

import org.junit.Before;
import org.junit.Test
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.TicTacToeBoard
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition;

class ThreeMarkTrackerTest extends GroovyTestCase {
	private List<Position> positions
	private Tracker tracker;
	
	@Before
	void setUp(){
		positions = [createPosition("1"), createPosition("2"), createPosition("3"), 
			createPosition("4"), createPosition("5"), createPosition("6"), 
				createPosition("7"), createPosition("8"), createPosition("9")]
		
		tracker = new ThreeMarkTracker()
	}

	@Test
	void testIsActive_Horizontal_Top_Same(){
		positions[0] = createPosition("A")
		positions[1] = createPosition("A")
		positions[2] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_Horizontal_Middle_Same(){
		positions[3] = createPosition("A")
		positions[4] = createPosition("A")
		positions[5] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}
	
	@Test
	void testIsActive_Horizontal_Bottom_Same(){
		positions[6] = createPosition("A")
		positions[7] = createPosition("A")
		positions[8] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_Verticle_Left_Same(){
		positions[0] = createPosition("A")
		positions[3] = createPosition("A")
		positions[6] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}
	
	@Test
	void testIsActive_Verticle_Center_Same(){
		positions[1] = createPosition("A")
		positions[4] = createPosition("A")
		positions[7] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}
	
	@Test
	void testIsActive_Verticle_Right_Same(){
		positions[2] = createPosition("A")
		positions[5] = createPosition("A")
		positions[8] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_Diagonal_LeftToRight_Same(){
		positions[0] = createPosition("A")
		positions[4] = createPosition("A")
		positions[8] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_Diagonal_RightToLeft_Same(){
		positions[2] = createPosition("A")
		positions[4] = createPosition("A")
		positions[6] = createPosition("A")
		Board board = new TicTacToeBoard(positions:positions)
		
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == false
	}

	@Test
	void testIsActive_AllDifferent(){
		Board board = new TicTacToeBoard(positions:positions)
		assert tracker.isActive(board) == true
		assert tracker.isActive(board) == true
	}

	private Position createPosition(String value){
		new TestPosition(value)
	}
}
