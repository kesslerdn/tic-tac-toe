package org.kesslerdn.tictactoe.game;

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark

interface Tracker {
	boolean isActive(Board board)
	int calculateScore(Mark mark, Board board)
}
