package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import org.kesslerdn.tictactoe.board.Board

interface PositionsLocator {
	List<Integer> locate(Board board)
}
