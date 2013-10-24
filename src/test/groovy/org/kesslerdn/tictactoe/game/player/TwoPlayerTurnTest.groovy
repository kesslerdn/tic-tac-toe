package org.kesslerdn.tictactoe.game.player;

import static org.junit.Assert.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.game.Turn;
import org.mockito.Mock
import static org.mockito.Mockito.*
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner.class)
class TwoPlayerTurnTest extends GroovyTestCase {

	@Mock private Player firstPlayer
	@Mock private Player secondPlayer
	
	@Test
	public void test() {
		when(firstPlayer.mark).thenReturn("A")
		when(secondPlayer.mark).thenReturn("B")
		
		Turn players = new TwoPlayerTurn(firstPlayer, secondPlayer)
		assert "A" == players.next().mark
		assert "B" == players.next().mark
		assert "A" == players.next().mark
		assert "B" == players.next().mark
	}

}
