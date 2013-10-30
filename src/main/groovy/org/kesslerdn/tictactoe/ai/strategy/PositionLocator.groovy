package org.kesslerdn.tictactoe.ai.strategy

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark

interface PositionLocator {
	Integer locate(Board board, Mark mark)
}
