package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

interface PositionLocator {
	Integer locate(Board board)
}
