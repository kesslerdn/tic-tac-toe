package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position

class ThreeMarkTracker implements Tracker {

	@Override
	public Boolean isActive(Board board) {
		areTheSame(board, 0, 1, 2) || 
		areTheSame(board, 3, 4, 5) || 
		areTheSame(board, 6, 7, 8)
	}

	private Boolean areTheSame(Board board, int first, int second, int third){
		extractValue(board, first) == extractValue(board, second) && extractValue(board, second) == extractValue(board, third)
	}
	
	private String extractValue(Board board, int index){
		board.positions[index].write()
	}
}
