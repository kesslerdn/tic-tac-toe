package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Test


class TwoPlayerTurnTest extends GroovyTestCase {

	private Player firstPlayer
	private Player secondPlayer
	
	@Test
	void test() {
		
		Turn players = new TwoPlayerTurn(firstPlayer, secondPlayer)
		assertSame(firstPlayer, players.next())
		assertSame(secondPlayer, players.next())
		assertSame(firstPlayer, players.next())
		assertSame(secondPlayer, players.next())
		assertSame(firstPlayer, players.next())
	}

}
