package org.kesslerdn.tictactoe.game

interface PositionLocator {
	int locate(Board board, Mark mark)
}
