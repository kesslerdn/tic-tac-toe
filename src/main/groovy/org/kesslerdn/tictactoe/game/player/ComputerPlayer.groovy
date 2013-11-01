package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl

class ComputerPlayer implements Player {
	
	Mark mark
	GameControl gameControl
	PositionLocator positionLocator
	
	@Override
	void play(Board board) {
		int position = positionLocator.locate(board, mark)
		gameControl.status("Player $mark played position ${position}.")
		board.mark(position, mark)
	}
}
