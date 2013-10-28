package org.kesslerdn.tictactoe.game.ai

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class ThreePositionRowAnalyzer implements RowAnalyzer {

	@Override
	public Boolean isAdvantagious(Mark opposingMark, Mark playerMark,
			List<Position> row) {
		count(row,opposingMark) == 0 && count(row, playerMark) == 1
	}
			
	@Override
	public Boolean isWin(Mark opposingMark, Mark playerMark,
			List<Position> row) {
		count(row,opposingMark) == 0 && count(row, playerMark) == 2
	}
			
	@Override
	public Boolean isProactive(Mark opposingMark, Mark playerMark,
			List<Position> row) {
		count(row,opposingMark) == 1 && count(row, playerMark) == 0
	}
		
	@Override
	public Boolean isVulnerable(Mark opposingMark, Mark playerMark,
			List<Position> row) {
		count(row,opposingMark) == 2 && count(row, playerMark) == 0
	}
		
	@Override
	public List<Integer> openPositions(Mark opposingMark, Mark playerMark,
			List<Position> row) {
		List<Position> openPositions = row.findAll{![opposingMark, playerMark].contains(it.mark)}
		openPositions.collect{it.index}
	}
			
	private Integer count(List<Position> row, Mark mark){
		row.count{it.mark == mark}
	}

}
