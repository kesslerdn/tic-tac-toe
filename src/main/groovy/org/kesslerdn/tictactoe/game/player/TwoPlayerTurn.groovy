package org.kesslerdn.tictactoe.game.player

import org.kesslerdn.tictactoe.game.Turn

class TwoPlayerTurn implements Turn {

	private List<Player> players
	private int currentIndex
	
	TwoPlayerTurn(Player first, Player second){
		players = [first, second]
		currentIndex = 1;
	}

	@Override
	public Player next() {
		currentIndex++
		players[currentIndex % 2]
	}
}
