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
		if(!tracker.isActive(board)) throw new IllegalStateException();
		
		def currentPlayer
		while(tracker.isActive(board)){
			gameControl.status(board.display())
			String position = gameControl.request('Please select a position:')
			currentPlayer = players.next()
			board.mark(position, currentPlayer)
		}
		
		gameControl.status("Player $currentPlayer won")
		gameControl.status(board.display())
	}
}