package org.kesslerdn.tictactoe.ai.strategy.score.calculation.board

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.score.BoardCalculation
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.TrialPosition;
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class OppositeCornerCalculation implements BoardCalculation {

	@Resource private PositionUtil positionUtil
	@Resource private MarkUtil markUtil
	
	@Override
	public int calculate(int total, Board board, TrialPosition trialPosition) {
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
	
	@Override
	int compareTo(Object o) {
		TOP
	}

}
