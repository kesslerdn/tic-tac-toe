package org.kesslerdn.tictactoe.game

import javax.annotation.Resource

import org.kesslerdn.tictactoe.view.GameControl;
import org.springframework.stereotype.Component

@Component
class FinalScore implements Score {

	@Resource private GameControl gameControl
	@Resource private Tracker tracker
	private static final Mark secondMark = Mark.O
	private static final Mark firstMark = Mark.X

	@Override
	void display(Board board) {
		int firstScore = tracker.calculateScore(firstMark, board)
		int secondScore = tracker.calculateScore(secondMark, board)
		gameControl.status(board.display())
		if(firstScore == secondScore){
			gameControl.status("This game ended in a tie!")
		}else if(firstScore > secondScore){
			gameControl.status("Player '$firstMark' won!")
		}else{
			gameControl.status("Player '$secondMark' won!")
		}
	}
}
