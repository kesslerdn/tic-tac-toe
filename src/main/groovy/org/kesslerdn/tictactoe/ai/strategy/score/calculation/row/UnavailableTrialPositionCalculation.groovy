package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class UnavailableTrialPositionCalculation implements TrialRowCalculation{
	
	@Resource private PositionUtil positionUtil
	
	@Override
	int compareTo(Object o) {
		return BOTTOM
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(positionUtil.containsBoth(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions())){
			score = 0
		}
		score
	}
}
