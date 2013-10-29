package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{

	private static final int TWO_OPPOSING_MATCHES = -1
	private static final int HIGHEST_SCORE = 4
	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		Integer score = 0
		List<Position> trialPositions = positions.findAll{it.index == trialPosition.index && it.mark == null}
		List<Position> opposingPositions = positions.findAll{it.mark && it.mark != trialPosition.mark}
		List<Position> playersPositions = positions.findAll{it.mark && it.mark == trialPosition.mark}
		if(!trialPositions.empty){
			score++
			score += (opposingPositions.size())
			score += (playersPositions.size() * 2)

			if(opposingPositions.size > 1){
				score += 1
			}
			if(!playersPositions.empty && !opposingPositions.empty){
				score = 0
			}
		}
		score == TWO_OPPOSING_MATCHES ? HIGHEST_SCORE : score
	}

}
