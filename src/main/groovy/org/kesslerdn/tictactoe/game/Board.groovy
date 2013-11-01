package org.kesslerdn.tictactoe.game

interface Board {
	List<Position> positions
	List<List<Position>> rows
	
	String display()
	void mark(int positionValue, Mark mark)
	List<List<Position>> getRows()
	List<Position> getPositions()
	boolean isOpen(int position)
}
