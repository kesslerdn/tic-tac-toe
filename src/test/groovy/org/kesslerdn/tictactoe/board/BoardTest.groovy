package org.kesslerdn.tictactoe.board

import groovy.util.GroovyTestCase

import org.kesslerdn.tictactoe.board.Board;
import org.kesslerdn.tictactoe.board.position.Position;

class BoardTest extends GroovyTestCase {

	void testStart_WithoutPositions() {
		Board board = new Board();
		assert '' == board.display()
	}
	
	void testStart_WithPositions(){
		Board board = new Board([new TestPosition("1"), 
			new TestPosition("2"), 
			new TestPosition("3")]);;
		
		assert 'test 1,test 2,test 3,' == board.display()
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
