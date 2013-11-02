package org.kesslerdn.tictactoe.ai.strategy.score

import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.PositionLocator
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component


@Component
class ScorePositionLocator implements PositionLocator {
	
	@Resource private ScoreCalculator scoreCalculator
	@Resource private MarkUtil markUtil
	@Resource private PositionUtil positionUtil
	@Resource private TrialPositionFactory trialPositionFactory
	
	@Override
	int locate(Board board, Mark mark) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionUtil.openPositions(board)
		List<Position> trialPositions = trialPositionFactory.create(positions, mark)
		trialPositions.each{trialPosition ->
			int total = 0
			board.rows.each{row ->
				 total += scoreCalculator.calculate(row, trialPosition)
			}
			positionScores[trialPosition.index] = favorEvenWhenOppositeCornersMarked(total, board, trialPosition)
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key
	}

	
	private int favorEvenWhenOppositeCornersMarked(int total, Board board, Position trialPosition){
		Mark mark = trialPosition.mark
		Mark opposingMark= markUtil.retrieveOpponentMark(trialPosition.mark)
		List<Position> opposingPositions = board.positions.findAll{it.mark && it.mark == opposingMark}
		if(opposingPositions.size() == 2 &&
			positionUtil.areOppositeCornersMarked(opposingPositions, opposingMark) &&
			positionUtil.isEven(trialPosition)){
			total += 10
		}
		total
	}

}
