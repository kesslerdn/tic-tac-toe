package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.Board

class OffensivePositionStrategy implements PositionStrategy {

	String mark
	String opposingMark
	RowAnalyzer rowAnalyzer
	
	@Override
	public String findPosition(Board board) {
		String position
		board.rows.each{ row ->
			if(rowAnalyzer.isAdvantagious(opposingMark,mark, row)){
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
