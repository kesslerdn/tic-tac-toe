package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.Match
import org.kesslerdn.tictactoe.game.player.TestComputerPlayer
import org.kesslerdn.tictactoe.view.TestGameControl
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringComputerVsComputerTest extends GroovyTestCase {

	private static final String TIE = 'This game ended in a tie!'

	private Match match
	private TestComputerPlayer firstPlayer
	private TestGameControl gameControl
	
	@Test
	void testStart_ScenarioOne() {
		[1,2,3,4,5,6,7,8,9].each{
			ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-computer-vs-computer-context.xml")
			match = context.getBean(Match.class)
			firstPlayer = context.getBean("firstPlayer")
			gameControl = context.getBean(TestGameControl.class)
			firstPlayer.firstPosition = it
			match.start()
		}
	}
}
