package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class CenterPositionStrategy implements PositionStrategy {

	private static final Mark mark = Mark.O
	private static final Mark opposingMark = Mark.X
	private static final int weight = 1

	@Override
	public PositionCounter addPositions(Board board,PositionCounter positionCounter) {
		Mark centerPosition = board.positions[4].mark
		if(!centerPosition){
			 weight.times{positionCounter.add(5)}
		}
		positionCounter;
	}
}
