package org.kesslerdn.board

import groovy.util.GroovyTestCase

class NewGameTest extends GroovyTestCase {

	void testStart() {
		TicTacToe game = TicTacToe.instance();
		assert '''|1|2|3|
|4|5|6|
|7|8|9|
''' == game.board()
	}
}
