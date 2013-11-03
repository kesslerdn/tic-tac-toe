package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.Match
import org.kesslerdn.tictactoe.game.player.TestHumanPlayer
import org.kesslerdn.tictactoe.view.TestGameControl
import org.springframework.context.support.ClassPathXmlApplicationContext


class SpringHumanVsComputerTest extends GroovyTestCase {

	private static final String TIE = 'This game ended in a tie!'
	private static final String O_WON = "Player 'O' won!"
	private static final String X_WON = "Player 'X' won!"
	
	private Match match
	private TestHumanPlayer firstPlayer
	private TestGameControl gameControl
	
	@Before
	void setUp(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("test-human-vs-computer-context.xml")
		match = context.getBean(Match.class)
		firstPlayer = context.getBean(TestHumanPlayer.class)
		gameControl = context.getBean(TestGameControl.class)
	}
	
	@Test
	void testStart_ScenarioOne() {
		firstPlayer.testingPositions = [1,3,4, 6, 8]
		gameControl.expectedMessages = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 7.",
			"Player O played position 9.",
						
			expectedBoard(  "X","O","X",
							"X","O","X",
							"O","X","O"),
						
							TIE]
		
		match.start()
	}

	@Test
	void testStart_ScenarioTwo() {
		firstPlayer.testingPositions = [3,7,6, 1, 8]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 9.",
			"Player O played position 4.",
			
			expectedBoard(  "X","O","X",
							"O","O","X",
							"X","X","O"),
						
							TIE]
	
		match.start()
	}

	@Test
	void testStart_ScenarioThree() {
		firstPlayer.testingPositions = [5,4,9,2,7]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 6.",
			"Player O played position 1.",
			"Player O played position 8.",
			
			expectedBoard(  "O","X","O",
							"X","X","O",
							"X","O","X"),
						
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioFour() {
		firstPlayer.testingPositions = [3,8,6]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 9.",
			"Player O played position 1.",
			
			expectedBoard(  "O","2","X",
							"4","O","X",
							"7","X","O"),
 
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioFive() {
		firstPlayer.testingPositions = [1,4,3, 9,8]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 7.",
			"Player O played position 2.",
			"Player O played position 6.",
 
			expectedBoard(  "X","O","X",
							"X","O","O",
							"O","X","X"),
 
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioSix() {
		firstPlayer.testingPositions = [9,7,1,2,6]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 8.",
			"Player O played position 4.",
			"Player O played position 3.",
			
			expectedBoard(  "X","X","O",
							"O","O","X",
							"X","O","X"),
						
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioSeven() {
		firstPlayer.testingPositions = [2,6,8]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 3.",
			"Player O played position 7.",
			
			expectedBoard(  "1","X","O",
							"4","O","X",
							"O","X","9"),
						
							O_WON]
	
		match.start()
	}

	@Test
	void testStart_ScenarioEight() {
		firstPlayer.testingPositions = [5,9,7, 6, 2]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 1.",
			"Player O played position 8.",
			"Player O played position 4.",
			
			expectedBoard(  "O","X","O",
							"O","X","X",
							"X","O","X"),
						
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioNine() {
		firstPlayer.testingPositions = [5,4,8, 7, 9]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 6.",
			"Player O played position 2.",
			"Player O played position 1.",
			
			expectedBoard(  "O","O","O",
							"X","X","O",
							"X","X","9"),
						
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioTen() {
		firstPlayer.testingPositions = [1,8,4,9]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 7.",
			"Player O played position 3.",
			
			expectedBoard(  "X","2","O",
							"X","O","6",
							"O","X","9"),
						
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioEleven() {
		firstPlayer.testingPositions = [3,7,9,6]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 8.",
						
			expectedBoard(  "1","O","X",
							"4","O","6",
							"X","O","X"),
						
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioTwelve() {
		firstPlayer.testingPositions = [3,9,4,8,1]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 6.",
			"Player O played position 2.",
			"Player O played position 7.",
			
			expectedBoard(  "X","O","X",
							"X","O","O",
							"O","X","X"),
						
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioThirteen() {
		firstPlayer.testingPositions = [3,6,1,7,8]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 9.",
			"Player O played position 2.",
			"Player O played position 4.",
			
			expectedBoard(  "X","O","X",
							"O","O","X",
							"X","X","O"),
						
							TIE]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioFourteen() {
		firstPlayer.testingPositions = [9,1,7]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 8.",
			
			expectedBoard(  "X","O","3",
							"4","O","6",
							"X","O","X"),
						
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioFifteen() {
		firstPlayer.testingPositions = [3,7,9]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 8.",
			
			expectedBoard(  "1","O","X",
							"4","O","6",
							"X","O","X"),
						
							O_WON]
	
		match.start()
	}
	
	@Test
	void testStart_ScenarioSixteen() {
		firstPlayer.testingPositions = [5,7,9,4,2]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 1.",
			"Player O played position 8.",
			"Player O played position 6.",
			
			expectedBoard(  "O","X","O",
							"X","X","O",
							"X","O","X"),
						
							TIE]
	
		match.start()
	}
	
	
	@Test
	void testStart_ScenarioSeventeen() {
		firstPlayer.testingPositions = [3,7,9]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 8.",
			
			expectedBoard(  "1","O","X",
							"4","O","6",
							"X","O","X"),
						
							O_WON]
	
		match.start()
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
