package org.kesslerdn.tictactoe.game.player

import static junit.framework.Assert.*

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl

class TestPlayer implements Player {
	
	String mark
	List<String> testingPositions = []
	List<String> expectedBoard = []
	private int i
	@Override
	public void play(Board board) {
		assertEquals(expectedBoard[i], board.display())
		board.mark(testingPositions[i], mark)
		i++
	}
}
