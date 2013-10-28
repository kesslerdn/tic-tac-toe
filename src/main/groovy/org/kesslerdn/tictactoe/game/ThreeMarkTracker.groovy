package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
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
	public Integer calculateScore(Mark mark, Board board) {
		Integer score = 0
		board.rows.each { row ->
			if(areSame(row) && mark == row[0].mark){
				 score++
			}
		}
		score
	}
	
	private Boolean areSame(List<Position> row){
		List<Mark> allMarks = row.collect{it.mark}
		List<Mark> marks = allMarks.findAll{it != null}
		List<Mark> nullMarks = allMarks.findAll{it == null}
		List<Mark> uniqueList = marks.unique(false)
		uniqueList.size() == 1 && nullMarks.empty
	}
}
