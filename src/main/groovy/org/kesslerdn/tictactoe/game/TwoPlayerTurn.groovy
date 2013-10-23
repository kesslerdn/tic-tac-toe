package org.kesslerdn.tictactoe.game

import java.util.Iterator

class TwoPlayerTurn implements Turn {

	private List<String> players
	private int currentIndex
	
	TwoPlayerTurn(String first, String second){
		players = [first, second]
		currentIndex = 1;
	}

	@Override
	public String next() {
		currentIndex++
		players[currentIndex % 2]
	}
}
