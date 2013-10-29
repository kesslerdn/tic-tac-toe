package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.board.Board

interface PositionsLocator {
	List<Integer> locate(Board board)
}
