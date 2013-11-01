package org.kesslerdn.tictactoe.game


interface Tracker {
	boolean isActive(Board board)
	int calculateScore(Mark mark, Board board)
}
