package org.kesslerdn.tictactoe.board

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position;

interface Board {
	List<Position> positions
	List<List<Position>> rows
	
	String display()
	void mark(String positionValue, String value)
	List<List<Position>> getRows()
	List<Position> getPositions()
	Boolean isOpen(String position)
}
