package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Position
import org.springframework.stereotype.Component

@Component
class BoardScoreCalculator implements BoardCalculator{

	@Resource private RowCalculator rowCalculator
	
	@Override
	public int calculate(Board board, Position position) {
		int total = 0
		board.rows.each{row ->
			 total += rowCalculator.calculate(row, position)
		}
		total
	}
}
