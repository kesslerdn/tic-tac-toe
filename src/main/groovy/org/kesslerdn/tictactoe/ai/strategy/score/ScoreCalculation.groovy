package org.kesslerdn.tictactoe.ai.strategy.score

interface ScoreCalculation extends Comparable{
	static final int TOP = -1
	static final int BOTTOM = 1
	
	int calculate(int score, TrialRow trialRow)
}
