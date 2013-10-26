package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class ThreeMarkTracker implements Tracker {
	
	private int turnCount
	
	@Override
	public Boolean isActive(Board board) {
		checkRows(board.rows)
	}

	private Boolean checkRows(List<List<Position>> rows){
		Boolean isActive = true
		rows.each { row ->
			if(areSame(row)){
				 isActive = false
			}
		}
		isActive
	}
	
	private Boolean areSame(List<Position> row){
		def uniqueList = row.unique{a, b -> a.value.compareTo(b.value)}
		uniqueList.size() == 1
	}
}
