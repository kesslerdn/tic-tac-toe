package org.kesslerdn.tictactoe.ai.strategy.cumulative

import org.kesslerdn.tictactoe.ai.PositionCounter;
import org.kesslerdn.tictactoe.board.Board;


interface PositionStrategy {
	PositionCounter addPositions(Board board, PositionCounter positionCounter)
}
