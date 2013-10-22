package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.CenterPosition;
import org.kesslerdn.tictactoe.board.position.EndPosition;
import org.kesslerdn.tictactoe.board.position.Position;
import org.kesslerdn.tictactoe.board.position.StartPosition;

class Board {

	List<Position> positions
	
	private Board(List<Position> positions = []){
		this.positions = new ArrayList<List>(positions)
	}
	
	String display(){
		String value = ""
		positions.each{value += it.write()}
		value
	}
}
