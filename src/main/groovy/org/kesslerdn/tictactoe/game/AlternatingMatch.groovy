package org.kesslerdn.tictactoe.game;

import javax.annotation.Resource;

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl
import org.springframework.stereotype.Component;


@Component
public class AlternatingMatch implements Match {

	@Resource private Board board;
	@Resource private GameControl gameControl;
	@Resource private Turn players;
	@Resource private Tracker tracker;
	
	@Override
	public void start() {
		def currentPlayer
		while(tracker.isActive(board)){
			players.next().play(board)
			players.next().play(board)
		}
		
		gameControl.status(board.display())
		gameControl.status("Player ?? won")
	}
}