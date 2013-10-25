package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.board.position.Position

class TestPosition implements Position {

	String value;
	Integer index
	
	TestPosition(Integer index = -1, String value){
		this.value = value
		this.index = index
	}
	
	@Override
	public String write() {
		"test ${value},"
	}
}
