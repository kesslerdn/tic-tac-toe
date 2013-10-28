package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class OpenPositionStrategy implements PositionStrategy {

	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	@Resource RowAnalyzer rowAnalyzer
	private static final int weight = 1
	
	@Override
	public PositionCounter addPositions(Board board, PositionCounter positionCounter) {
		board.rows.each{ row ->
			List<String> openPositions = rowAnalyzer.openPositions(opposingMark, mark, row)
			openPositions.each{position ->
				weight.times {positionCounter.add(position)}
			}
		}
		positionCounter
	}
}
