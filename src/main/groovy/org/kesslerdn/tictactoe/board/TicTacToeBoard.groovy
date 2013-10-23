package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.CenterPosition;
import org.kesslerdn.tictactoe.board.position.EndPosition;
import org.kesslerdn.tictactoe.board.position.Position;
import org.kesslerdn.tictactoe.board.position.StartPosition;

class TicTacToeBoard implements Board{

	List<Position> positions
	
	TicTacToeBoard(List<Position> positions = []){
		this.positions = new ArrayList<List>(positions)
	}

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
}
