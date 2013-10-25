package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.ai.RowAnalyzer
import org.kesslerdn.tictactoe.view.GameControl

class ComputerPlayer implements Player {
	
	String mark
	String opposingMark
	GameControl gameControl
	RowAnalyzer rowAnalyzer
	
	@Override
	public void play(Board board) {
		List<Integer> strategicPlays = []
		List<Integer> plays = []
		gameControl.status(board.display())
		List<List<Position>> rows = board.rows
		rows.each{ row ->
			if(rowAnalyzer.isVulnerable(opposingMark, row)){
				strategicPlays << rowAnalyzer.firstOpenPosition(opposingMark, mark, row)
			}else{
				plays << rowAnalyzer.firstOpenPosition(opposingMark, mark, row)
			}
		}
		if(strategicPlays.empty){
			board.mark(plays[0].toString(), mark)
		}else{
			board.mark(strategicPlays[0].toString(), mark)
		}
	}
}
