package org.kesslerdn.tictactoe.game;

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.Score
import org.springframework.stereotype.Component


@Component
public class AlternatingMatch implements Match {

	static final int MAX_ROUNDS = 4
	@Resource private Board board;
	@Resource private Turn players;
	@Resource private Tracker tracker;
	@Resource private Score score
	
	@Override
	public void start() {
		int round
		while(tracker.isActive(board) && round < MAX_ROUNDS){
			players.next().play(board)
			players.next().play(board)
			round++
		}
		if(!score.hasWinner(board)){
			players.next().play(board)
		}
		score.display(board)
	}
}