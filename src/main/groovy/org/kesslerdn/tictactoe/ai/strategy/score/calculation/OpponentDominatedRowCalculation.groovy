package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class OpponentDominatedRowCalculation implements ScoreCalculation{
	
	@Override
	int compareTo(Object o) {
		return TOP
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(trialRow.extractOpposingPositions().size() == 2){
			score = 100000
		}
		score
	}
}
