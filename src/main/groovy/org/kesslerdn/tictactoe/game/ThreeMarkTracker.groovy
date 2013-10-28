package org.kesslerdn.tictactoe.game

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.springframework.stereotype.Component

@Component
class ThreeMarkTracker implements Tracker {
	
	private int turnCount
	
	@Override
	public Boolean isActive(Board board) {
		Boolean isActive = true
		board.rows.each { row ->
			if(areSame(row)){
				 isActive = false
			}
		}
		isActive
	}
	
	@Override
	public Integer calculateScore(String mark, Board board) {
		Integer score = 0
		board.rows.each { row ->
			if(areSame(row) && mark == row[0].value){
				 score++
			}
		}
		score
	}
	
	private Boolean areSame(List<Position> row){
		def uniqueList = row.unique(false){a, b -> a.value.compareTo(b.value)}
		uniqueList.size() == 1
	}
}
