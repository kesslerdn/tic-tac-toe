package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class ProactivePositionStrategy implements PositionStrategy {
	private static final Mark mark = Mark.O
	private static final Mark opposingMark = Mark.X
	@Resource RowAnalyzer rowAnalyzer
	private static final int weight = 1
	
	@Override
	public PositionCounter addPositions(Board board, PositionCounter positionCounter) {
		board.rows.each{ row ->
			if(rowAnalyzer.isProactive(opposingMark,mark, row)){
				List<Integer> openPositions = rowAnalyzer.openPositions(opposingMark, mark, row)
				openPositions.each{position ->
					weight.times{positionCounter.add(position)}
				}
			}
		}
		positionCounter
	}
}
