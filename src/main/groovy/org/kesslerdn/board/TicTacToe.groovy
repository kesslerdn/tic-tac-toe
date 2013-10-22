package org.kesslerdn.board

import org.kesslerdn.board.position.CenterPosition
import org.kesslerdn.board.position.EndPosition
import org.kesslerdn.board.position.Position
import org.kesslerdn.board.position.StartPosition

class TicTacToe {

	List<Position> positions
	
	private TicTacToe(List<Position> positions = []){
		this.positions = new ArrayList<List>(positions)
	}
	
	String board(){
		String value = ""
		positions.each{value += it.write()}
		value
	}
}
