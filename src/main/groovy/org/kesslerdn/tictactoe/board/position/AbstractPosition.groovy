package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark


abstract class AbstractPosition implements Position{
	int index
	Mark mark;
	
	@Override
	public String write() {
		String output = mark ? mark : index
		format(output)
	}
	
	abstract String format(String value)
}