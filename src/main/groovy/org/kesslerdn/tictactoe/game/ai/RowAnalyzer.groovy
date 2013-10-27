package org.kesslerdn.tictactoe.game.ai;

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position

interface RowAnalyzer {
	Boolean isVulnerable(String opposingMark, String playerMark, List<Position> row)
	Boolean isAdvantagious(String opposingMark, String playerMark, List<Position> row)
	List<String> openPositions(String opposingMark, String playerMark, List<Position> row)
}
