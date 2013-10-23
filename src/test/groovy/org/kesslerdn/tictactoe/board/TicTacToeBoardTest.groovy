package org.kesslerdn.tictactoe.board

import groovy.util.GroovyTestCase

import org.kesslerdn.tictactoe.board.TicTacToeBoard;
import org.kesslerdn.tictactoe.board.position.Position;

class TicTacToeBoardTest extends GroovyTestCase {

	void testStart_WithoutPositions() {
		TicTacToeBoard board = new TicTacToeBoard();
		assert '' == board.display()
	}
	
	void testStart_WithPositions(){
		TicTacToeBoard board = new TicTacToeBoard([new TestPosition("1"), 
			new TestPosition("2"), 
			new TestPosition("3")])
		
		assert 'test 1,test 2,test 3,' == board.display()
	}
	
	void testStart_MarkPosition(){
		TicTacToeBoard board = new TicTacToeBoard([new TestPosition("1"),
			new TestPosition("2"),
			new TestPosition("3")])
		
		assert 'test 1,test 2,test 3,' == board.display()
		board.mark("2", "A")
		assert 'test 1,test A,test 3,' == board.display()
		
	}
}

class TestPosition implements Position{

	String value;
	
	TestPosition(String value){
		this.value = value
	}
	
	@Override
	public String write() {
		"test ${value},"
	}
	
}
