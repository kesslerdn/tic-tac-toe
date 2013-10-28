package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class CenterPositionStrategy implements PositionStrategy {

	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	private static final int weight = 1

	@Override
	public PositionCounter addPositions(Board board,PositionCounter positionCounter) {
		String centerPosition = board.positions[4].value
		if(centerPosition != opposingMark && centerPosition != mark){
			 weight.times{positionCounter.add("5")}
		}
		positionCounter;
	}
}
