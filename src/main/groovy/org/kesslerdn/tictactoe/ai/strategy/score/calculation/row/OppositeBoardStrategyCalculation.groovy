package org.kesslerdn.tictactoe.ai.strategy.score.calculation.row

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowCalculation
import org.kesslerdn.tictactoe.game.TrialRow;
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class OppositeBoardStrategyCalculation implements TrialRowCalculation{
	
	@Resource private PositionUtil positionUtil
	
	@Override
	int compareTo(Object o) {
		return TOP
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		if(positionUtil.hasMoreEvens(trialRow.extractOpposingPositions()) && positionUtil.isOdd(trialRow.trialPosition)){
			score += 5
		}else if(positionUtil.hasMoreOdds(trialRow.extractOpposingPositions()) && positionUtil.isEven(trialRow.trialPosition)){
			score += 5
		}
		score
	}
}
