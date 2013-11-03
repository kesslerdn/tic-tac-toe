package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.TrialRow

interface TrialRowCalculation extends ScoreCalculation{
	int calculate(int score, TrialRow trialRow)
}
