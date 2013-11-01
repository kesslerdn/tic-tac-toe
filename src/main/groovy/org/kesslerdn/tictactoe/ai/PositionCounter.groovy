package org.kesslerdn.tictactoe.ai

interface PositionCounter {
	void add(int position)
	int largest()
	boolean isEmpty()
}
