package org.kesslerdn.board

import org.kesslerdn.board.position.CenterPosition
import org.kesslerdn.board.position.EndPosition
import org.kesslerdn.board.position.Position
import org.kesslerdn.board.position.StartPosition

class TicTacToe {

	List<Position> positions
	
	private TicTacToe(){}
	
	static TicTacToe instance(){
		new TicTacToe(positions:[	new StartPosition("1"), new CenterPosition("2"), new EndPosition("3"),
									new StartPosition("4"), new CenterPosition("5"), new EndPosition("6"),
									new StartPosition("7"), new CenterPosition("8"), new EndPosition("9")])
	}
	
	String board(){
		String value = ""
		positions.each{value += it.write()}
		value
	}
}
