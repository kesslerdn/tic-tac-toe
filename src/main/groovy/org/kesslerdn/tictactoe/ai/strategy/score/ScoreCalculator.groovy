package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.board.position.Position

interface ScoreCalculator {
	Integer calculate(List<Position> positions, Position position)
}
