package org.kesslerdn.tictactoe

import javax.annotation.Resource;

import groovy.util.GroovyTestCase

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kesslerdn.tictactoe.board.TicTacToeBoard;
import org.kesslerdn.tictactoe.board.position.Position;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/application-context.xml")
class SpringBoardTest extends GroovyTestCase {

	@Resource
	private TicTacToeBoard board
	
	@Test
	void testSpringConfiguration() {
		assert '''|1|2|3|
|4|5|6|
|7|8|9|
''' == board.display()
	}
}
