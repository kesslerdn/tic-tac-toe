package org.kesslerdn.tictactoe.util;

import groovy.util.GroovyTestCase;

import org.junit.Test;
import org.kesslerdn.tictactoe.game.player.Mark;

public class MarkUtilTest extends GroovyTestCase {

	@Test
	void testRetrieveOpponentMark_X(){
		assert Mark.O == new MarkUtil().retrieveOpponentMark(Mark.X)
	}

	@Test
	void testRetrieveOpponentMark_O(){
		assert Mark.X == new MarkUtil().retrieveOpponentMark(Mark.O)
	}
}
