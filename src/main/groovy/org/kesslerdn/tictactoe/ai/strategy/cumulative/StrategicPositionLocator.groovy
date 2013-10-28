package org.kesslerdn.tictactoe.ai.strategy.cumulative

import org.kesslerdn.tictactoe.ai.PositionCounter;
import org.kesslerdn.tictactoe.ai.PositionCounterFactory;
import org.kesslerdn.tictactoe.ai.strategy.PositionLocator;
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
