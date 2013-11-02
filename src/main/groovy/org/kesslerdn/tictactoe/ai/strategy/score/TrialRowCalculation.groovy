package org.kesslerdn.tictactoe.ai.strategy.score

interface TrialRowCalculation extends ScoreCalculation{
	int calculate(int score, TrialRow trialRow)
}
