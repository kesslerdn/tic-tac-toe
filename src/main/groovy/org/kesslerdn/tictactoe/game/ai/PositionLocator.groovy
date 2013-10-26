package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

interface PositionLocator {
	String locate(Board board)
}
