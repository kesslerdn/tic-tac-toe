package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark

interface Position {
	int index
	Mark mark
	String write()
}
