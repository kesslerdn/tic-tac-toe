package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark

class TrialPosition implements Position {

	int index
	Mark mark
	
	@Override
	String write() {
		throw new IllegalAccessException()
	}
}
