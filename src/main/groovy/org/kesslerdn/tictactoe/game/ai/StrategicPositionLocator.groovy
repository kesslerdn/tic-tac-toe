package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

class StrategicPositionLocator implements PositionLocator {

	List<PositionStrategy> positionStrategies
	
	@Override
	public String locate(Board board) {
		String position
		positionStrategies.each{ strategy ->
			if(position == null && strategy.isValid(board)){
				position = strategy.findPosition(board)
			}
		}
		position
	}
}
