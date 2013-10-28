package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component


@Component
class ExhaustivePositionLocator implements PositionLocator {

	private static final Mark mark = Mark.O
	private static final Mark opposingMark = Mark.X
	
	@Resource private PositionsLocator positionsLoctor
	@Resource private ScoreCalculator scoreCalculator
	
	@Override
	public Integer locate(Board board) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionsLoctor.locate(board)
		positions.each{position ->
			Position trialPosition = new TrialPosition(index:position, mark:mark)
			board.rows.each{row ->
				positionScores[position] = scoreCalculator.calculate(row, trialPosition)
			}
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key;
	}

}
