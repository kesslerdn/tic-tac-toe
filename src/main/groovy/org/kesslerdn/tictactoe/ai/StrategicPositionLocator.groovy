package org.kesslerdn.tictactoe.ai

import org.kesslerdn.tictactoe.ai.strategy.cumulative.PositionStrategy
import org.kesslerdn.tictactoe.board.Board

class StrategicPositionLocator implements PositionLocator {

	List<PositionStrategy> positionStrategies
	PositionCounterFactory positionCounterFactory
	
	@Override
	public Integer locate(Board board) {
		PositionCounter positionCounter = positionCounterFactory.create()
		positionStrategies.each{ strategy ->
			strategy.addPositions(board, positionCounter)
		}
		positionCounter.largest()
	}
}
