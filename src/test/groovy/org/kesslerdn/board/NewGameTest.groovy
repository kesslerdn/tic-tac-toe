package org.kesslerdn.board

import groovy.util.GroovyTestCase

import org.kesslerdn.board.position.Position

class NewGameTest extends GroovyTestCase {

	void testStart_WithoutPositions() {
		TicTacToe game = new TicTacToe();
		assert '' == game.board()
	}
	
	void testStart_WithPositions(){
		TicTacToe game = new TicTacToe([new TestPosition("1"), 
			new TestPosition("2"), 
			new TestPosition("3")]);;
		
		assert 'test 1,test 2,test 3,' == game.board()
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
