package org.kesslerdn.tictactoe.game;

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark

interface Tracker {
	Boolean isActive(Board board)
	Integer calculateScore(Mark mark, Board board)
}
