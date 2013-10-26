package org.kesslerdn.tictactoe.view

import org.kesslerdn.tictactoe.board.Board

interface Score {
	void display(Board board)
	Boolean hasWinner(Board board)
}
