package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

class OpenPositionStrategy implements Strategy {

	String mark
	String opposingMark
	RowAnalyzer rowAnalyzer

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
