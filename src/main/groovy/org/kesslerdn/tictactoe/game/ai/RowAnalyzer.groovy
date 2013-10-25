package org.kesslerdn.tictactoe.game.ai;

import org.kesslerdn.tictactoe.board.position.Position

interface RowAnalyzer {
	Boolean isVulnerable(String opponentMark, List<Position> row)
	Integer firstOpenPosition(String opponentMark, String playerMark, List<Position> row)
}
