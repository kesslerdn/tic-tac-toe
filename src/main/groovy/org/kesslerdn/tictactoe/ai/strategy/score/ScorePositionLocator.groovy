package org.kesslerdn.tictactoe.ai.strategy.score

import java.util.List
import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Board;
import org.kesslerdn.tictactoe.game.Mark;
import org.kesslerdn.tictactoe.game.Position;
import org.kesslerdn.tictactoe.game.PositionLocator;
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component


@Component
class ScorePositionLocator implements PositionLocator {
	
	@Resource private ScoreCalculator scoreCalculator
	@Resource private MarkUtil markUtil
	@Resource private PositionUtil positionUtil
	
	@Override
	int locate(Board board, Mark mark) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionUtil.openPositions(board)
		positions.each{position ->
			Position trialPosition = new TrialPosition(index:position, mark:mark)
			positionScores[trialPosition.index] = calculateBoardScenario(board, trialPosition)
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key
	}

	private int calculateBoardScenario(Board board, Position trialPosition){
		int total = 0
		board.rows.each{row ->
			 total += scoreCalculator.calculate(row, trialPosition)
		}
		total = favorEvenWhenOppositeCornersMarked(total, board, trialPosition)
		total
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
