package org.kesslerdn.tictactoe.game.ai

interface PositionCounter {
	void add(Integer position)
	Integer largest()
	Boolean isEmpty()
}
