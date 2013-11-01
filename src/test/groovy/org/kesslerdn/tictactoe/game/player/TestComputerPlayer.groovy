package org.kesslerdn.tictactoe.game.player

import java.util.List

import org.kesslerdn.tictactoe.game.Board

class TestComputerPlayer extends ComputerPlayer {

	int firstPosition
	boolean used = false
	
	@Override
	void play(Board board) {
		int position
		if(!used){
			position = firstPosition
			used = true
		}else{
		 	position = positionLocator.locate(board, mark)
		}
		board.mark(position, mark)
	}
}
