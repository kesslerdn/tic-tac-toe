package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{

	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		return null;
	}

}
