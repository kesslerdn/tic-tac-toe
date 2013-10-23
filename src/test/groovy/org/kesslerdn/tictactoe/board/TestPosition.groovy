package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.Position

class TestPosition implements Position {

	String value;
	
	TestPosition(String value){
		this.value = value
	}
	
	@Override
	public String write() {
		"test ${value},"
	}
}
