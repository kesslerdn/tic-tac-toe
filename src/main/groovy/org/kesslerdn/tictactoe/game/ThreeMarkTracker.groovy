package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position

class ThreeMarkTracker implements Tracker {

	@Override
	public Boolean isActive(Board board) {
		List<Position> positions = board.positions
		positions[0].write() == positions[1].write() && positions[1].write() == positions[2].write()
	}

}
