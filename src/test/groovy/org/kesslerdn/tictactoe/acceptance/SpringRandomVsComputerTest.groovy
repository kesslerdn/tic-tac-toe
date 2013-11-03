package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.Match
import org.kesslerdn.tictactoe.game.player.TestComputerPlayer
import org.kesslerdn.tictactoe.view.TestGameControl
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringRandomVsComputerTest extends GroovyTestCase {

	private Match match
	private TestGameControl gameControl
	
	@Test
	void testStart() {
		(1..10).each{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-random-vs-computer-context.xml")
			match = context.getBean(Match.class)
			gameControl = context.getBean(TestGameControl.class)
			match.start()
		}
	}
}
