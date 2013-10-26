package org.kesslerdn.tictactoe.view

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.Tracker
import org.springframework.stereotype.Component

@Component
class FinalScore implements Score {

	@Resource private GameControl gameControl;
	@Resource private Tracker tracker;
	@Resource private String firstMark
	@Resource private String secondMark

	@Override
	public void display(Board board) {
		Integer firstScore = tracker.calculateScore(firstMark, board)
		Integer secondScore = tracker.calculateScore(secondMark, board)
		gameControl.status(board.display())
		if(firstScore == secondScore){
			gameControl.status("This game ended in a tie!")
		}else if(firstScore > secondScore){
			gameControl.status("Player '$firstMark' won!")
		}else{
			gameControl.status("Player '$secondMark' won!")
		}
	}
	
	@Override
	public Boolean hasWinner(Board board) {
		Integer firstScore = tracker.calculateScore(firstMark, board)
		Integer secondScore = tracker.calculateScore(secondMark, board)
		firstScore != secondScore
	}
}
