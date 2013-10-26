package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Match
import org.kesslerdn.tictactoe.game.player.TestPlayer
import org.kesslerdn.tictactoe.view.TestGameControl;
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringMatchTest extends GroovyTestCase {

	private Match match
	private TestPlayer firstPlayer
	private TestGameControl gameControl
	
	@Before
	public void setUp(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-context.xml")
		match = context.getBean(Match.class)
		firstPlayer = context.getBean(TestPlayer.class)
		gameControl = context.getBean(TestGameControl.class)
	}
	
	@Test
	void testStart_WithTopLeft() {
		firstPlayer.testingPositions = ["1","5","4", "7"]
		gameControl.expectedMessages = [
			expectedBoard(  "X","2","3",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "X","O","3",
							"4","X","6",
							"7","8","9"),
						
			expectedBoard(  "X","O","3",
							"X","X","6",
							"7","8","O"),
						
			expectedBoard(  "X","O","3",
							"X","X","O",
							"X","8","O"),
						
			expectedBoard(  "X","O","O",
							"X","X","O",
							"X","8","O"),
						
							'Player ?? won']
		
		match.start();
	}


	@Test
	void testStart_WithTopRight() {
		firstPlayer.testingPositions = ["3","5","6", "9"]
		gameControl.expectedMessages  = [
			expectedBoard(  "1","2","X",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "O","2","X",
							"4","X","6",
							"7","8","9"),
						
			expectedBoard(  "O","2","X",
							"4","X","X",
							"O","8","9"),
 
			expectedBoard(  "O","2","X",
							"O","X","X",
							"O","8","9"),
 
							'Player ?? won']
	
		match.start();
	}
	
	private String expectedBoard(String one, String two, String three, 
		String four, String five, String six, 
		String seven, String eight, String nine){
		"""|$one|$two|$three|
|$four|$five|$six|
|$seven|$eight|$nine|
"""
	}
}
