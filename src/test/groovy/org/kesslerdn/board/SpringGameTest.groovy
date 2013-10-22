package org.kesslerdn.board

import javax.annotation.Resource;

import groovy.util.GroovyTestCase

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kesslerdn.board.position.Position
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-context.xml")
class SpringGameTest extends GroovyTestCase {

	@Resource
	private TicTacToe game
	
	@Test
	void testSpringConfiguration() {
		assert '''|1|2|3|
|4|5|6|
|7|8|9|
''' == game.board()
	}
}
