package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark

interface Board {
	List<Position> positions
	List<List<Position>> rows
	
	String display()
	void mark(int positionValue, Mark mark)
	List<List<Position>> getRows()
	List<Position> getPositions()
	boolean isOpen(int position)
}
