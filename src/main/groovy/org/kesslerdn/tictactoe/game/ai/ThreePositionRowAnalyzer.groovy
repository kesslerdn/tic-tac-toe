package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class ThreePositionRowAnalyzer implements RowAnalyzer {

	@Override
	public Boolean isVulnerable(String opposingMark, List<Position> row) {
		row.count{it.value == opposingMark} == 2
	}

	@Override
	public Integer firstOpenPosition(String opposingMark, String playerMark,
			List<Position> row) {
		List<Position> openPositions = row.findAll{![opposingMark, playerMark].contains(it.value)}
		if(openPositions.empty){
			null
		}else{
			openPositions[0].index
		}
	}
}
