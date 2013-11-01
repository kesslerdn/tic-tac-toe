package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import java.util.List

import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position

class TestRandomHumanPlayer implements Player {
	
	private static List<Integer> plays = []
	private static final Mark mark = Mark.X
	private List<String> testingPositions = []
	private int i
	
	@Override
	void play(Board board) {
		List<Position> openPositions = board.positions.findAll{it.mark == null}
		Collections.shuffle(openPositions)
		int position = openPositions[0].index
		if(!board.isOpen(position)){
			 throw new IllegalStateException("Position $position does not work on: \n" + board.display())
		}
		plays << position
		board.mark(position, mark)
		i++
	}
}
