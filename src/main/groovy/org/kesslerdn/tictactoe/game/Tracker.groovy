package org.kesslerdn.tictactoe.game;

import org.kesslerdn.tictactoe.board.Board

interface Tracker {
	Boolean isActive(Board board)
	Integer calculateScore(String mark, Board board)
}
