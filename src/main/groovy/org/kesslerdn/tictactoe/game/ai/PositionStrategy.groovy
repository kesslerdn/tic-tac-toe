package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board;


interface PositionStrategy {
	Boolean isValid(Board board)
	String findPosition(Board board)
}
