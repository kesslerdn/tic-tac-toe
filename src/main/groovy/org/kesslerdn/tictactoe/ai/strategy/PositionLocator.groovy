package org.kesslerdn.tictactoe.ai.strategy

import org.kesslerdn.tictactoe.board.Board

interface PositionLocator {
	Integer locate(Board board)
}
