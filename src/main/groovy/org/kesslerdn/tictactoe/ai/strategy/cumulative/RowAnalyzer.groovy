package org.kesslerdn.tictactoe.ai.strategy.cumulative;

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark

interface RowAnalyzer{
	Boolean isVulnerable(Mark opposingMark, Mark playerMark, List<Position> row)
	Boolean isProactive(Mark opposingMark, Mark playerMark, List<Position> row)
	Boolean isAdvantagious(Mark opposingMark, Mark playerMark, List<Position> row)
	Boolean isWin(Mark opposingMark, Mark playerMark, List<Position> row)
	List<Integer> openPositions(Mark opposingMark, Mark playerMark, List<Position> row)
}