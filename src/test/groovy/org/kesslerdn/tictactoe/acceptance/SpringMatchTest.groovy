package org.kesslerdn.tictactoe.acceptance

import javax.annotation.Resource

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.game.Match
import org.kesslerdn.tictactoe.game.player.TestPlayer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/test-context.xml")
class SpringMatchTest extends GroovyTestCase {

	@Resource
	private Match match
	
	@Resource
	private TestPlayer firstPlayer
	
	@Test
	void testStart() {
		firstPlayer.testingPositions = ["1","5","4", "7"]
		firstPlayer.expectedBoard = ['''|1|2|3|
|4|5|6|
|7|8|9|
''', 
'''|X|O|3|
|4|5|6|
|7|8|9|
''', 
'''|X|O|3|
|4|X|6|
|7|8|O|
''', 
'''|X|O|3|
|X|X|O|
|7|8|O|
''']
		
		match.start();
	}
}
