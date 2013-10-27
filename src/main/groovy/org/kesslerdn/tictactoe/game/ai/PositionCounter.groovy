package org.kesslerdn.tictactoe.game.ai

interface PositionCounter {
	void add(String position)
	String largest()
	Boolean isEmpty()
}
