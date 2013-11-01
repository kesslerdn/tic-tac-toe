package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource;

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.util.PositionUtil;
import org.springframework.stereotype.Component

@Component
class OpenPositionsLocator implements PositionsLocator {

	@Resource private PositionUtil positionUtil
	
	@Override
	public List<Integer> locate(Board board) {
		List<Position> openPositions = positionUtil.findMark(board.positions, null)
		openPositions.collectAll{it.index}
	}
}
