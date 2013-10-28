package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class OpenPositionsLocator implements PositionsLocator {

	@Override
	public List<Integer> locate(Board board) {
		List<Position> openPositions = []
		board.rows.each{row ->
			openPositions.addAll(row.findAll{it.mark == null})
		}
		openPositions.collectAll{it.index}
	}
}
