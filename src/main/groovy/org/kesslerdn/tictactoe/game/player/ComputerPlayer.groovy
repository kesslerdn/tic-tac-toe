package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.ai.PositionLocator
import org.kesslerdn.tictactoe.view.GameControl

class ComputerPlayer implements Player {
	
	String mark
	GameControl gameControl
	PositionLocator positionLocator
	
	@Override
	public void play(Board board) {
		boolean marked
		String position = positionLocator.locate(board)
		gameControl.status("Player $mark played position ${position}.")
		board.mark(position, mark)
	}
}
