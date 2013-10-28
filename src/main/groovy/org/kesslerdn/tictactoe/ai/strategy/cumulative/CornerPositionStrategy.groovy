package org.kesslerdn.tictactoe.ai.strategy.cumulative

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.PositionCounter;
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class CornerPositionStrategy implements PositionStrategy {

	private static final Mark mark = Mark.O
	private static final Mark opposingMark = Mark.X

	@Resource RowAnalyzer rowAnalyzer
	private static final int weight = 1
	
	@Override
	public PositionCounter addPositions(Board board, PositionCounter positionCounter) {
		Mark topLeft = board.positions[0].mark
		Mark topRight = board.positions[2].mark
		Mark bottomLeft = board.positions[6].mark
		Mark bottomRight = board.positions[8].mark

		Mark centerPosition = board.positions[4].mark
		if(!centerPosition) positionCounter.add(5)

		String position
		if (!topLeft){
			 weight.times{positionCounter.add(1)}
		}
		if (!topRight){
			weight.times{positionCounter.add(3)}
		}
		if (!bottomLeft){
			weight.times{positionCounter.add(7)}
		}
		if (!bottomRight){
			weight.times{positionCounter.add(9)}
		}
		
		positionCounter;
	}
}
