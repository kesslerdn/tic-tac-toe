package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Position

interface ScoreCalculation extends Comparable{
	static final int TOP = -1
	static final int BOTTOM = 1
}
