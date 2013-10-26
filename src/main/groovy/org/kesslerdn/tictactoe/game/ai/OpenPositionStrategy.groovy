package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class OpenPositionStrategy implements PositionStrategy {

	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	@Resource RowAnalyzer rowAnalyzer

	@Override
	public String findPosition(Board board) {
		String position
		board.rows.each{row ->
			Integer play = rowAnalyzer.firstOpenPosition(opposingMark, mark, row)
			if(play != null && position == null){
				position = play.toString()
			}
		}
		position
	}

	@Override
	public Boolean isValid(Board board) {
		findPosition(board) != null
	}
}
