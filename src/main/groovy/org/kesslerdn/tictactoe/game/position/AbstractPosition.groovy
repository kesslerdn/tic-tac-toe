package org.kesslerdn.tictactoe.game.position

import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position


abstract class AbstractPosition implements Position{
	int index
	Mark mark
	
	@Override
	String write() {
		String output = mark ? mark : index
		format(output)
	}
	
	abstract String format(String value)
}