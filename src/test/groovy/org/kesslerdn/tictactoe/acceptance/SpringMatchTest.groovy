package org.kesslerdn.tictactoe.acceptance

import org.junit.Before
import org.junit.Ignore;
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
	void testStart_ScenarioOne() {
		firstPlayer.testingPositions = ["1","3","4", "6", "8"]
		gameControl.expectedMessages = [
			"Player O played position 5.",
			"Player O played position 2.",
			"Player O played position 7.",
			"Player O played position 9.",
						
			expectedBoard(  "X","O","X",
							"X","O","X",
							"O","X","O"),
						
							'This game ended in a tie!']
		
		match.start();
	}

	@Test
	void testStart_ScenarioTwo() {
		firstPlayer.testingPositions = ["3","7","6", "1", "8"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 1.",
			"Player O played position 9.",
 
			expectedBoard(  "O","2","X",
							"4","O","X",
							"X","8","O"),
						
							"Player 'O' won!"]
	
		match.start();
	}

	@Test
	void testStart_ScenarioThree() {
		firstPlayer.testingPositions = ["5","4","9","2","7"]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 6.",
			"Player O played position 1.",
			"Player O played position 8.",
			
			expectedBoard(  "O","X","O",
							"X","X","O",
							"X","O","X"),
						
							"This game ended in a tie!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFour() {
		firstPlayer.testingPositions = ["3","8","6", "7", "2"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 9.",
			"Player O played position 1.",
 
			expectedBoard(  "O","2","X",
							"4","O","X",
							"7","X","O"),
 
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFive() {
		firstPlayer.testingPositions = ["1","4","3", "8", "6"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 7.",
			"Player O played position 2.",
			"Player O played position 9.",
 
			expectedBoard(  "X","O","X",
							"X","O","X",
							"O","X","O"),
 
							"This game ended in a tie!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSix() {
		firstPlayer.testingPositions = ["9","7","1", "3", "8"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 8.",
			"Player O played position 2.",
 
			expectedBoard(  "X","O","3",
							"4","O","6",
							"X","O","X"),
						
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSeven() {
		firstPlayer.testingPositions = ["2","6","8", "4", "8"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 3.",
			"Player O played position 7.",
 
			expectedBoard(  "1","X","O",
							"4","O","X",
							"O","X","9"),
						
							"Player 'O' won!"]
	
		match.start();
	}

	@Test
	void testStart_ScenarioEight() {
		firstPlayer.testingPositions = ["5","9","7", "6", "2"]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 1.",
			"Player O played position 2.",
 
			expectedBoard(  "O","O","O",
							"4","X","6",
							"X","8","X"),
						
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioNine() {
		firstPlayer.testingPositions = ["5","4","8", "7", "9"]
		gameControl.expectedMessages  = [
			"Player O played position 3.",
			"Player O played position 6.",
			"Player O played position 9.",
						
			expectedBoard(  "1","2","O",
							"X","X","O",
							"7","X","O"),
						
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioTen() {
		firstPlayer.testingPositions = ["1","8","3", "4", "6"]
		gameControl.expectedMessages  = [
			"Player O played position 5.",
			"Player O played position 7.",
			"Player O played position 2.",
			"Player O played position 9.",
						
			expectedBoard(  "X","O","X",
							"X","O","X",
							"O","X","O"),
						
							"This game ended in a tie!"]
	
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
