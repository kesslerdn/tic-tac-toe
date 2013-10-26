package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

class DefensiveStrategy implements Strategy {

	String mark
	String opposingMark
	RowAnalyzer rowAnalyzer
	
	@Override
	public String findPosition(Board board) {
		String position
		board.rows.each{ row ->
			if(rowAnalyzer.isVulnerable(opposingMark,mark, row)){
				position = rowAnalyzer.firstOpenPosition(opposingMark, mark, row).toString()
			}
		}
		position
	}
	
	@Override
	public Boolean isValid(Board board) {
		findPosition(board) != null
	}
}
