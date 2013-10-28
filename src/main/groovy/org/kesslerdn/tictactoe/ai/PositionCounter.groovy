package org.kesslerdn.tictactoe.ai

interface PositionCounter {
	void add(Integer position)
	Integer largest()
	Boolean isEmpty()
}
