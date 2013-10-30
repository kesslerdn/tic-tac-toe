package org.kesslerdn.tictactoe.ai.strategy.score

import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component


@Component
class ScorePositionLocator implements PositionLocator {
	
	@Resource private PositionsLocator positionsLoctor
	@Resource private ScoreCalculator scoreCalculator
	
	@Override
	public Integer locate(Board board, Mark mark) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionsLoctor.locate(board)
		positions.each{position ->
			Position trialPosition = new TrialPosition(index:position, mark:mark)
			int total = 0
			board.rows.each{row ->
				 total += scoreCalculator.calculate(row, trialPosition)
			}
			positionScores[trialPosition.index] = total
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key;
	}

}
