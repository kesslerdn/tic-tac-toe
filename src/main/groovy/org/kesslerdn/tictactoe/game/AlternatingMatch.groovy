package org.kesslerdn.tictactoe.game

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.game.player.Turn
import org.kesslerdn.tictactoe.view.Score
import org.springframework.stereotype.Component


@Component
class AlternatingMatch implements Match {

	static final int MAX_PLAYS = 9
	@Resource private Board board
	@Resource private Turn players
	@Resource private Tracker tracker
	@Resource private Score score
	
	@Override
	void start() {
		int round
		while(tracker.isActive(board) && round < MAX_PLAYS){
			players.next().play(board)
			round++
		}
		score.display(board)
	}
}