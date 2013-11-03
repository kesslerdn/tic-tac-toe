package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.game.TrialRow;
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class OpponentSelectedRowCalculation implements TrialRowCalculation{
	
	@Resource private PositionUtil positionUtil
	
	@Override
	int compareTo(Object o) {
		return TOP
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(positionUtil.containsOnlyOpponenet(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions())){
			score += 5
		}
		score
	}
}
