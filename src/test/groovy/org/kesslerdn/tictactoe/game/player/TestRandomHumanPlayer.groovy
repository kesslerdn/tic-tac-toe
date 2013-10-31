package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import java.util.List;

import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position

class TestRandomHumanPlayer implements Player {
	
	static List<Integer> plays = []
	static final Mark mark = Mark.X
	List<String> testingPositions = []
	private int i
	
	@Override
	public void play(Board board) {
		List<Position> openPositions = board.positions.findAll{it.mark == null}
		Collections.shuffle(openPositions)
		Integer position = openPositions[0].index
		if(!board.isOpen(position)){
			 throw new IllegalStateException("Position $position does not work on: \n" + board.display())
		}
		plays << position
		board.mark(position, mark)
		i++
	}
}
