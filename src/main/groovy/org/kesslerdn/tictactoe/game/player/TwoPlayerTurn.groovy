package org.kesslerdn.tictactoe.game.player


class TwoPlayerTurn implements Turn {

	private List<Player> players
	private int currentIndex
	
	TwoPlayerTurn(Player first, Player second){
		players = [first, second]
		currentIndex = 1
	}

	@Override
	Player next() {
		currentIndex++
		players[currentIndex % 2]
	}
}
