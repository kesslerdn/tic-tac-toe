package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Position

interface RowCalculator {
	int calculate(List<Position> positions, Position position)
}
