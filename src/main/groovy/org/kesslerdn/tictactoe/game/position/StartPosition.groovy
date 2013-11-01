package org.kesslerdn.tictactoe.game.position

class StartPosition extends AbstractPosition{

	@Override
	String format(String value) {
		"|$value|"
	}
}
