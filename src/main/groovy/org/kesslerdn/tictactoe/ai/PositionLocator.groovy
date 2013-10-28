package org.kesslerdn.tictactoe.ai

import org.kesslerdn.tictactoe.board.Board

interface PositionLocator {
	Integer locate(Board board)
}
