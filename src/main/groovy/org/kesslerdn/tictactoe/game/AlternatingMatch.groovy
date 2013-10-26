package org.kesslerdn.tictactoe.game;

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.Score
import org.springframework.stereotype.Component


@Component
public class AlternatingMatch implements Match {

	@Resource private Board board;
	@Resource private Turn players;
	@Resource private Tracker tracker;
	@Resource private Score score
	
	@Override
	public void start() {
		def currentPlayer
		while(tracker.isActive(board)){
			players.next().play(board)
			players.next().play(board)
		}
		score.display(board)
	}
}