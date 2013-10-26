package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.board.Board;
import org.kesslerdn.tictactoe.view.GameControl;

class HumanPlayer implements Player {
	
	String mark
	GameControl gameControl

	@Override
	public void play(Board board) {
		gameControl.status(board.display())
		String position = gameControl.request("Player $mark please select a position")
		while(!board.isOpen(position)){
			gameControl.status("Player $mark selected ${position}. This is an invalid move.")
			position = gameControl.request("Player $mark please select a position")
		}
		board.mark(position, mark)
	}
}
