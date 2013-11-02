package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Position

interface BoardCalculator{	
	int calculate(Board board, Position position)
}
