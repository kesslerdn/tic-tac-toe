package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.ai.PositionLocator;
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl

class ComputerPlayer implements Player {
	
	static final Mark mark = Mark.O
	GameControl gameControl
	PositionLocator positionLocator
	
	@Override
	public void play(Board board) {
		boolean marked
		Integer position = positionLocator.locate(board)
		gameControl.status("Player $mark played position ${position}.")
		board.mark(position, mark)
	}
}
