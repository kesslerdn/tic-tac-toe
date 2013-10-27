package org.kesslerdn.tictactoe.game.ai

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class ThreePositionRowAnalyzer implements RowAnalyzer {

	@Override
	public Boolean isAdvantagious(String opposingMark, String playerMark,
			List<Position> row) {
		count(row,opposingMark) == 0 && count(row, playerMark) != 0
	}
			
	@Override
	public Boolean isVulnerable(String opposingMark, String playerMark,
			List<Position> row) {
		count(row,opposingMark) == 2 && count(row, playerMark) != 1
	}
		
	@Override
	public List<String> openPositions(String opposingMark, String playerMark,
			List<Position> row) {
		List<Position> openPositions = row.findAll{![opposingMark, playerMark].contains(it.value)}
		openPositions.collect{it.index.toString()}
	}
			
	private Integer count(List<Position> row, String mark){
		row.count{it.value == mark}
	}
}
