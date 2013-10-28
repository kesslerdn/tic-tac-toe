package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class DefensivePositionStrategy implements PositionStrategy {
	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	@Resource RowAnalyzer rowAnalyzer
	private static final int weight = 4
	
	@Override
	public PositionCounter addPositions(Board board, PositionCounter positionCounter) {
		board.rows.each{ row ->
			if(rowAnalyzer.isVulnerable(opposingMark,mark, row)){
				List<String> openPositions = rowAnalyzer.openPositions(opposingMark, mark, row)
				openPositions.each{position ->
					weight.times{positionCounter.add(position)}
				}
			}
		}
		positionCounter
	}
}
