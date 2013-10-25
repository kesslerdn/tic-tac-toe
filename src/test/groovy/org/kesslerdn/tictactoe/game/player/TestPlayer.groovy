package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.kesslerdn.tictactoe.board.Board

class TestPlayer implements Player {
	
	String mark
	List<String> testingPositions = []
	private int i
	
	@Override
	public void play(Board board) {
		board.mark(testingPositions[i], mark)
		i++
	}
}
