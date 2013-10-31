package org.kesslerdn.tictactoe.game.player

import java.util.List;

import org.kesslerdn.tictactoe.board.Board;

class TestComputerPlayer extends ComputerPlayer {

	Integer firstPosition
	Boolean used = false
	
	@Override
	public void play(Board board) {
		Integer position
		if(!used){
			position = firstPosition
			used = true
		}else{
		 	position = positionLocator.locate(board, mark)
		}
		board.mark(position, mark)
	}
}
