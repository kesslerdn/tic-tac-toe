package org.kesslerdn.tictactoe.game

import javax.annotation.Resource

import org.kesslerdn.tictactoe.util.RowUtil
import org.springframework.stereotype.Component

@Component
class ThreeMarkTracker implements Tracker {
	
	private int turnCount
	@Resource private RowUtil rowUtil
	
	@Override
	boolean isActive(Board board) {
		boolean isActive = true
		board.rows.each { row ->
			if(rowUtil.hasSameMark(row)){
				 isActive = false
			}
		}
		isActive
	}
	
	@Override
	int calculateScore(Mark mark, Board board) {
		int score = 0
		board.rows.each { row ->
			if(rowUtil.hasSameMark(row) && mark == row[0].mark){
				 score++
			}
		}
		score
	}
}
