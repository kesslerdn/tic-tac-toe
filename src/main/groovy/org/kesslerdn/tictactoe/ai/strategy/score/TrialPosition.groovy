package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position

class TrialPosition implements Position {

	int index
	Mark mark
	
	@Override
	String write() {
		throw new IllegalAccessException()
	}
}
