package org.kesslerdn.tictactoe.board

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class TicTacToeBoard implements Board{

	@Resource List<Position> positions
	@Resource List<List<Position>> rows
	
	@Override
	String display(){
		String value = ""
		positions.each{value += it.write()}
		value
	}
	
	@Override
	void mark(String positionValue, String value){
		Position position = positions.find{it.value == positionValue}
		position.value = value
	}

	@Override
	public Boolean isOpen(String position) {
		return null;
	}
}
