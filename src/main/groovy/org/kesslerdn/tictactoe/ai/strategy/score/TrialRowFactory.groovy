package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class TrialRowFactory {
	
	@Resource private MarkUtil markUtil
	@Resource private PositionUtil positionUtil
	
	TrialRow create(List<Position> positions, Position trialPosition){
		new TrialRow(positions:positions, trialPosition:trialPosition, markUtil:markUtil, positionUtil:positionUtil)
	}
}
