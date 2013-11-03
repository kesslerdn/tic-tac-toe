package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.TrialPosition

interface BoardCalculation extends ScoreCalculation{
	int calculate(int total, Board board, TrialPosition trialPosition)
}
