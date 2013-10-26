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
		boolean marked
		gameControl.status(board.display())
		marked = blockOpponet(board, marked)
		playOpenPosition(board, marked)
	}

	private boolean blockOpponet(Board board, boolean marked) {
		board.rows.each{ row ->
			if(!marked && rowAnalyzer.isVulnerable(opposingMark,mark, row)){
				Integer play = rowAnalyzer.firstOpenPosition(opposingMark, mark, row)
				board.mark(play.toString(), mark)
				marked = true
			}
		}
		return marked
	}

	private boolean playOpenPosition(Board board, boolean marked) {
		board.rows.each{row ->
			Integer play = rowAnalyzer.firstOpenPosition(opposingMark, mark, row)
			if(!marked && play != null){
				board.mark(play.toString(), mark)
				marked = true
			}
		}
	}
}
