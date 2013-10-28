package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{

	private static final int TWO_OPPOSING_MATCHES = -1
	private static final int HIGHEST_SCORE = 4
	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		Integer score = 0
		Position matchingPosition = positions.find{it.index == trialPosition.index && it.mark == null}
		if(matchingPosition){
			score++
			positions.each{position ->
				if(position.mark == trialPosition.mark){
					score++
				}
				if(position.mark && position.mark != trialPosition.mark){
					score--
				}
			}
		}
		score == TWO_OPPOSING_MATCHES ? HIGHEST_SCORE : score
	}

}
