package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark

class StartPosition extends AbstractPosition{

	@Override
	String format(String value) {
		"|$value|"
	}
}
