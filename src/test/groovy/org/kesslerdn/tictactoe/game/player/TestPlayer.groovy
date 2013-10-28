package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.kesslerdn.tictactoe.board.Board

class TestPlayer implements Player {
	
	static final Mark mark = Mark.X
	List<String> testingPositions = []
	private int i
	
	@Override
	public void play(Board board) {
		Integer position = testingPositions[i]
		if(!board.isOpen(position)){
			 throw new IllegalStateException("Position $position does not work on: \n" + board.display())
		}
		board.mark(position, mark)
		i++
	}
}
