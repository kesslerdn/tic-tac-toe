package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock

import static org.mockito.Mockito.*

import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner.class)
class TwoPlayerTurnTest extends GroovyTestCase {

	@Mock private Player firstPlayer
	@Mock private Player secondPlayer
	
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
