package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark;

class EndPosition implements Position{
	Integer index
	Mark mark;

	@Override
	public String write() {
		String output = mark ? mark : index
		"|$output|\n"
	}
}
