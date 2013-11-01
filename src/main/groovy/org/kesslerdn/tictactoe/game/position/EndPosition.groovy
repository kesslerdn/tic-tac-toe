package org.kesslerdn.tictactoe.game.position

class EndPosition extends AbstractPosition{

	@Override
	String format(String value) {
		"|$value|\n"
	}
}
