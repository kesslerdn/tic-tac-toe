package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Position;

interface ScoreCalculator {
	int calculate(List<Position> positions, Position position)
}
