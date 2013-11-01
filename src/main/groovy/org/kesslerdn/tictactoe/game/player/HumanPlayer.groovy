package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.view.GameControl

class HumanPlayer implements Player {
	
	Mark mark
	GameControl gameControl

	@Override
	void play(Board board) {
		gameControl.status(board.display())
		int position = gameControl.request("Player $mark please select a position")
		while(!board.isOpen(position)){
			gameControl.status("This is an invalid move.")
			position = gameControl.request("Player $mark please select a position")
		}
		board.mark(position, mark)
	}
}
