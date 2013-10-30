package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark;

class EndPosition extends AbstractPosition{

	@Override
	public String format(String value) {
		"|$value|\n"
	}
}
