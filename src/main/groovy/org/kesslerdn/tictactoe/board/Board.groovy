package org.kesslerdn.tictactoe.board

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position;

interface Board {
	List<Position> positions
	
	String display()
	void mark(String positionValue, String value)
}
