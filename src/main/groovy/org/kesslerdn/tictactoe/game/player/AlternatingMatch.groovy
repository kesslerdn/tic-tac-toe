package org.kesslerdn.tictactoe.game.player

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.Board;
import org.kesslerdn.tictactoe.game.Score;
import org.kesslerdn.tictactoe.game.Tracker;
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