package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.PositionLocator
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
