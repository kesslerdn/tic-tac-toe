package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component;

@Component
class ThreeMarkTracker implements Tracker {
	
	@Override
	public Boolean isActive(Board board) {
		checkRows(board) && checkColumns(board) && checkDiagonals(board)
	}

	private Boolean checkRows(Board board){
		areDifferent(board, 0, 1, 2) &&
		areDifferent(board, 3, 4, 5) &&
		areDifferent(board, 6, 7, 8)
	}
	
	private Boolean checkColumns(Board board){
		areDifferent(board, 0, 3, 6) &&
		areDifferent(board, 1, 4, 7) &&
		areDifferent(board, 2, 5, 8)
	}
	
	private Boolean checkDiagonals(Board board){
		areDifferent(board, 0, 4, 8) &&
		areDifferent(board, 2, 4, 6)
	}

	private Boolean areDifferent(Board board, int first, int second, int third){
		extractValue(board, first) != extractValue(board, second) || extractValue(board, second) != extractValue(board, third)
	}
	
	private String extractValue(Board board, int index){
		board.positions[index].value
	}
}
