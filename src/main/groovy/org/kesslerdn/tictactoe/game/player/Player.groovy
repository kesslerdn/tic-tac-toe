package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl

interface Player {	
	void play(Board board)
	String getMark()
}
