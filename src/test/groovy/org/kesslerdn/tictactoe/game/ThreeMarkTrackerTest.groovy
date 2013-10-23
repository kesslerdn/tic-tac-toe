package org.kesslerdn.tictactoe.game

import org.junit.Before;
import org.junit.Test
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.TestPosition
import org.kesslerdn.tictactoe.board.TicTacToeBoard
import org.kesslerdn.tictactoe.board.position.Position

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
		Board board = new TicTacToeBoard(positions)
		
		assert tracker.isActive(board)
	}
	
	@Test
	void testIsActive_Horizontal_Top_Different(){
		Board board = new TicTacToeBoard(positions)
		assert tracker.isActive(board)
	}

	private Position createPosition(String value){
		new TestPosition(value)
	}
}
