package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark

interface Position {
	Integer index
	Mark mark
	String write()
}
