package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.position.Position

class ThreePositionRowAnalyzer implements RowAnalyzer {

	@Override
	public Boolean isVulnerable(String opponentMark, List<Position> row) {
		row.count{it.value == opponentMark} == 2
	}

	@Override
	public Integer firstOpenPosition(String opponentMark, String playerMark,
			List<Position> row) {
		List<Position> openPositions = row.findAll{![opponentMark, playerMark].contains(it.value)}
		if(openPositions.empty){
			null
		}else{
			openPositions[0].index
		}
	}
}
