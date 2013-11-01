package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark

class TestHumanPlayer implements Player {
	
	private static final Mark mark = Mark.X
	private List<String> testingPositions = []
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
