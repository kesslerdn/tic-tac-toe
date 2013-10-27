package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class CenterPositionStrategy implements PositionStrategy {

	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	@Resource RowAnalyzer rowAnalyzer
	
	@Override
	public String findPosition(Board board) {
		String centerPosition = board.positions[4].value
		centerPosition != opposingMark && centerPosition != mark ? "5" : null
	}
	
	@Override
	public Boolean isValid(Board board) {
		findPosition(board) != null
	}
}
