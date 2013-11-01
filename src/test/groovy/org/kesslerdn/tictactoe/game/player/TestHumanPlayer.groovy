package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.kesslerdn.tictactoe.board.Board

class TestHumanPlayer implements Player {
	
	static final Mark mark = Mark.X
	List<String> testingPositions = []
	private int i
	
	@Override
	void play(Board board) {
		int position = testingPositions[i]
		if(!board.isOpen(position)){
			 throw new IllegalStateException("Position $position does not work on: \n" + board.display())
		}
		board.mark(position, mark)
		i++
	}
}
