package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import javax.annotation.Resource;

import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow;
import org.kesslerdn.tictactoe.util.PositionUtil;
import org.springframework.stereotype.Component;

@Component
class UnavailableTrailPositionCalculation implements ScoreCalculation{
	
	@Resource private PositionUtil positionUtil
	
	@Override
	int compareTo(Object o) {
		return BOTTOM;
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(positionUtil.containsBoth(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions())){
			score = 0
		}
		score
	}
}
