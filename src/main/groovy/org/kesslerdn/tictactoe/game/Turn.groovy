package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.game.player.Player

interface Turn {
	Player next()
}
