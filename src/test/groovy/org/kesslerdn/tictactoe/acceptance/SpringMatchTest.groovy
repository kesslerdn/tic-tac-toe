package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Ignore;
import org.junit.Test
import org.kesslerdn.tictactoe.game.Match
import org.kesslerdn.tictactoe.game.player.TestPlayer
import org.kesslerdn.tictactoe.view.TestGameControl;
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringMatchTest extends GroovyTestCase {

	static final String TIE = 'This game ended in a tie!'

	static final String PLAYER_O_WON = "Player 'O' won!"

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
	void testStart_ScenarioOne() {
		firstPlayer.testingPositions = [1,3,4, 5, 8]
		gameControl.expectedMessages = [
			"Player O played position 6.",
			"Player O played position 2.",
			"Player O played position 7.",
			"Player O played position 9.",
						
			expectedBoard(  "X","O","X",
							"X","X","O",
							"O","X","O"),
						
							TIE]
		
		match.start();
	}

	@Test
	void testStart_ScenarioTwo() {
		firstPlayer.testingPositions = [3,7,6, 1, 8]
		gameControl.expectedMessages  = [
			"Player O played position 4.",
			"Player O played position 5.",
			"Player O played position 9.",
			"Player O played position 2.",
			
			expectedBoard(  "X","O","X",
							"O","O","X",
							"X","X","O"),
						
							TIE]
	
		match.start();
	}

	@Test
	void testStart_ScenarioThree() {
		firstPlayer.testingPositions = [5,4,9,3,8]
		gameControl.expectedMessages  = [
			"Player O played position 2.",
			"Player O played position 6.",
			"Player O played position 1.",
			"Player O played position 7.",
			
			expectedBoard(  "O","O","X",
							"X","X","O",
							"O","X","X"),
						
							TIE]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFour() {
		firstPlayer.testingPositions = [3,8,6, 9, 2]
		gameControl.expectedMessages  = [
			"Player O played position 4.",
			"Player O played position 1.",
			"Player O played position 7.",
 
			expectedBoard(  "O","2","X",
							"O","5","X",
							"O","X","9"),
 
							PLAYER_O_WON]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFive() {
		firstPlayer.testingPositions = [1,4,3, 8, 9]
		gameControl.expectedMessages  = [
			"Player O played position 6.",
			"Player O played position 7.",
			"Player O played position 2.",
			"Player O played position 5.",
 
			expectedBoard(  "X","O","X",
							"X","O","O",
							"O","X","X"),
 
							TIE]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSix() {
		firstPlayer.testingPositions = [9,7,1]
		gameControl.expectedMessages  = [
			"Player O played position 2.",
			"Player O played position 8.",
			"Player O played position 5.",
 
			expectedBoard(  "X","O","3",
							"4","O","6",
							"X","O","X"),
						
							PLAYER_O_WON]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSeven() {
		firstPlayer.testingPositions = [2,6,8, 4, 8]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 7.",
			"Player O played position 3.",
 
			expectedBoard(  "1","X","O",
							"4","O","X",
							"O","X","9"),
						
							PLAYER_O_WON]
	
		match.start();
	}

	@Test
	void testStart_ScenarioEight() {
		firstPlayer.testingPositions = [5,9,7, 6, 2]
		gameControl.expectedMessages  = [
			"Player O played position 2.",
			"Player O played position 1.",
			"Player O played position 3.",
 
			expectedBoard(  "O","O","O",
							"4","X","6",
							"X","8","X"),
						
							PLAYER_O_WON]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioNine() {
		firstPlayer.testingPositions = [5,4,8, 7, 9]
		gameControl.expectedMessages  = [
			"Player O played position 2.",
			"Player O played position 6.",
			"Player O played position 3.",
			"Player O played position 1.",
			
			expectedBoard(  "O","O","O",
							"X","X","O",
							"X","X","9"),
						
							PLAYER_O_WON]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioTen() {
		firstPlayer.testingPositions = [1,8,4, 5]
		gameControl.expectedMessages  = [
			"Player O played position 6.",
			"Player O played position 3.",
			"Player O played position 9.",
						
			expectedBoard(  "X","2","O",
							"X","5","O",
							"7","X","O"),
						
							PLAYER_O_WON]
	
		match.start();
	}
	//1 & 4
	@Test
	void testStart_ScenarioEleven() {
		firstPlayer.testingPositions = [3,7,9]
		gameControl.expectedMessages  = [
			"Player O played position 4.",
			"Player O played position 5.",
			"Player O played position 6.",
						
			expectedBoard(  "1","2","X",
							"O","O","O",
							"X","8","X"),
						
							PLAYER_O_WON]
	
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
