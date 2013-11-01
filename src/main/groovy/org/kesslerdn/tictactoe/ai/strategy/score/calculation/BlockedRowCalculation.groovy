package org.kesslerdn.tictactoe.ai.strategy.score.calculation

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculation
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRow
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class BlockedRowCalculation implements ScoreCalculation{
	
	@Resource private PositionUtil positionUtil
	
	@Override
	int compareTo(Object o) {
		return BOTTOM;
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(!positionUtil.containsIndex(trialRow.extractOpenPositions(), trialRow.trialPosition)){
			score = 0
		}
		score
	}
}
