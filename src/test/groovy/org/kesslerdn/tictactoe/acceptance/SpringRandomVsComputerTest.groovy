package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.player.Match;
import org.kesslerdn.tictactoe.game.player.TestComputerPlayer
import org.kesslerdn.tictactoe.view.TestGameControl
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringRandomVsComputerTest extends GroovyTestCase {

	static final String TIE = 'This game ended in a tie!'

	private Match match
	private TestGameControl gameControl
	
	@Before
	void setUp(){
		
	}
	
	@Test
	void testStart_ScenarioOne() {
		(1..100).each{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-random-vs-computer-context.xml")
			match = context.getBean(Match.class)
			gameControl = context.getBean(TestGameControl.class)
			match.start()
		}
	}
}
