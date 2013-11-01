package org.kesslerdn.tictactoe.game

import org.springframework.stereotype.Component

@Component
class ThreeMarkTracker implements Tracker {
	
	private int turnCount
	
	@Override
	boolean isActive(Board board) {
		boolean isActive = true
		board.rows.each { row ->
			if(areSame(row)){
				 isActive = false
			}
		}
		isActive
	}
	
	@Override
	int calculateScore(Mark mark, Board board) {
		int score = 0
		board.rows.each { row ->
			if(areSame(row) && mark == row[0].mark){
				 score++
			}
		}
		score
	}
	
	private boolean areSame(List<Position> row){
		List<Mark> allMarks = row.collect{it.mark}
		List<Mark> marks = allMarks.findAll{it != null}
		List<Mark> nullMarks = allMarks.findAll{it == null}
		List<Mark> uniqueList = marks.unique(false)
		uniqueList.size() == 1 && nullMarks.empty
	}
}
