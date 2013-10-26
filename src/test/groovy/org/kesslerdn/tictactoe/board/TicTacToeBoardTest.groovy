package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.TestPosition

class TicTacToeBoardTest extends GroovyTestCase {

	void testStart_WithoutPositions() {
		Board board = new TicTacToeBoard();
		assert '' == board.display()
	}
	
	void testStart_WithPositions(){
		Board board = new TicTacToeBoard(positions:[new TestPosition("1"), 
			new TestPosition("2"), 
			new TestPosition("3")])
		
		assert 'test 1,test 2,test 3,' == board.display()
	}
	
	void testIsOpen_WithPositions(){
		Board board = new TicTacToeBoard(positions:[new TestPosition("1"),
			new TestPosition("2"),
			new TestPosition("3")])
		
		assert board.isOpen("2")
	}
	
	void testIsOpen_NoMatch(){
		Board board = new TicTacToeBoard(positions:[new TestPosition("1"),
			new TestPosition("2"),
			new TestPosition("3")])
		
		assert board.isOpen("bad") == false
	}
	
	void testIsOpen_Empty(){
		Board board = new TicTacToeBoard(positions:[])
		
		assert board.isOpen("1") == false
	}

	void testStart_MarkPosition(){
		Board board = new TicTacToeBoard(positions:[new TestPosition("1"),
			new TestPosition("2"),
			new TestPosition("3")])
		
		assert 'test 1,test 2,test 3,' == board.display()
		board.mark("2", "A")
		assert 'test 1,test A,test 3,' == board.display()
		
	}
}
