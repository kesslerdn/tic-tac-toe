package org.kesslerdn.tictactoe.ai.strategy.score

import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.PositionLocator
import org.kesslerdn.tictactoe.game.TrialPositionFactory;
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component


@Component
class ScorePositionLocator implements PositionLocator {
	
	@Resource private BoardCalculator boardCalculator
	@Resource private PositionUtil positionUtil
	@Resource private TrialPositionFactory trialPositionFactory
	@Resource private SortedSet<BoardCalculation> scoreCalculations
	
	@Override
	int locate(Board board, Mark mark) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionUtil.openPositions(board)
		List<Position> trialPositions = trialPositionFactory.create(positions, mark)
		trialPositions.each{trialPosition ->
			int total = boardCalculator.calculate(board, trialPosition)
			scoreCalculations.each{calculation ->
				total = calculation.calculate(total, board, trialPosition)
			}
			positionScores[trialPosition.index] = total
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key
	}
}
