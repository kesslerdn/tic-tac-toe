package org.kesslerdn.tictactoe.game.ai;

import org.kesslerdn.tictactoe.board.position.Position

interface RowAnalyzer {
	Boolean isVulnerable(String opposingMark, String playerMark, List<Position> row)
	Integer firstOpenPosition(String opposingMark, String playerMark, List<Position> row)
}
