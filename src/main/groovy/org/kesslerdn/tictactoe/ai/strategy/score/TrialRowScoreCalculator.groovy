package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.TrialRow
import org.kesslerdn.tictactoe.game.TrialRowFactory
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements RowCalculator{
	
	
	private static final WEIGHT_MAP = [0:0, 1:10, 2:100, 3:1000]
	@Resource private PositionUtil positionUtil
	@Resource private TrialRowFactory trialRowFactory
	@Resource private SortedSet<TrialRowCalculation> scoreCalculations
	
	@Override
	int calculate(List<Position> positions, Position trialPosition) {
		TrialRow trialRow = trialRowFactory.create(positions, trialPosition)
		
		int score = 0
		
		if(positionUtil.isFirstTurnWithCenterPositionOpen(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions(), trialRow.trialPosition)){
			score = 100000
		}else if (positionUtil.isFirstTurnWithCenterPositionTaken(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions(), trialRow.trialPosition)){
			score = 100000
		}else{
			score = 1 * WEIGHT_MAP[trialRow.extractPlayerPositions().size()]
			scoreCalculations.each{score = it.calculate(score, trialRow)}
		}
		score
	}
}