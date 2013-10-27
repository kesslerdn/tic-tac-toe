package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board;


interface PositionStrategy {
	PositionCounter addPositions(Board board, PositionCounter positionCounter)
}
