package org.kesslerdn.tictactoe.game;

import static org.junit.Assert.*;

import org.junit.Test;

import groovy.util.GroovyTestCase;

class TwoPlayerTurnTest extends GroovyTestCase {

	@Test
	public void test() {
		Turn players = new TwoPlayerTurn("A", "B")
		assert "A" == players.next()
		assert "B" == players.next()
		assert "A" == players.next()
		assert "B" == players.next()
	}

}
