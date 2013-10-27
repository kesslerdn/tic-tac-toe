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
			expectedBoard(  "X","2","3",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "X","2","X",
							"4","O","6",
							"7","8","9"),
						
			expectedBoard(  "X","O","X",
							"X","O","6",
							"7","8","9"),
						
			expectedBoard(  "X","O","X",
							"X","O","X",
							"O","8","9"),
						
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
			expectedBoard(  "1","2","X",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "1","2","X",
							"4","O","6",
							"X","8","9"),
						
			expectedBoard(  "1","2","X",
							"O","O","X",
							"X","8","9"),
 
			expectedBoard(  "X","2","X",
							"O","O","X",
							"X","8","O"),
 
			expectedBoard(  "X","O","X",
							"O","O","X",
							"X","X","O"),
 
							'This game ended in a tie!']
	
		match.start();
	}

	@Test
	void testStart_ScenarioThree() {
		firstPlayer.testingPositions = ["5","3","4","2", "9"]
		gameControl.expectedMessages  = [
			expectedBoard(  "1","2","3",
							"4","X","6",
							"7","8","9"),
						
			expectedBoard(  "O","2","X",
							"4","X","6",
							"7","8","9"),
						
			expectedBoard(  "O","2","X",
							"X","X","6",
							"O","8","9"),
						
			expectedBoard(  "O","X","X",
							"X","X","O",
							"O","8","9"),
						
			expectedBoard(  "O","X","X",
							"X","X","O",
							"O","O","X"),
						
							'This game ended in a tie!']
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFour() {
		firstPlayer.testingPositions = ["3","8","6", "7", "2"]
		gameControl.expectedMessages  = [
			expectedBoard(  "1","2","X",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "1","2","X",
							"4","O","6",
							"7","X","9"),
						
			expectedBoard(  "1","2","X",
							"O","O","X",
							"7","X","9"),
 
			expectedBoard(  "1","2","X",
							"O","O","X",
							"X","X","O"),
 
			expectedBoard(  "O","2","X",
							"O","O","X",
							"X","X","O"),
 
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioFive() {
		firstPlayer.testingPositions = ["1","4","3", "9", "8"]
		gameControl.expectedMessages  = [
			expectedBoard(  "X","2","3",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "X","2","3",
							"X","O","6",
							"7","8","9"),
						
			expectedBoard(  "X","2","X",
							"X","O","6",
							"O","8","9"),
 
			expectedBoard(  "X","O","X",
							"X","O","6",
							"O","8","X"),
 
			expectedBoard(  "X","O","X",
							"X","O","O",
							"O","X","X"),
 
							"This game ended in a tie!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSeven() {
		firstPlayer.testingPositions = ["2","6","8", "4", "8"]
		gameControl.expectedMessages  = [
			expectedBoard(  "1","X","3",
							"4","5","6",
							"7","8","9"),
						
			expectedBoard(  "1","X","3",
							"4","O","X",
							"7","8","9"),
						
			expectedBoard(  "1","X","O",
							"4","O","X",
							"7","X","9"),
 
			expectedBoard(  "1","X","O",
							"4","O","X",
							"O","X","9"),
						
							"Player 'O' won!"]
	
		match.start();
	}
	
	@Test
	void testStart_ScenarioSix() {
		firstPlayer.testingPositions = ["9","7","1", "3", "8"]
		gameControl.expectedMessages  = [
			expectedBoard(  "1","2","3",
							"4","5","6",
							"7","8","X"),
						
			expectedBoard(  "1","2","3",
							"4","O","6",
							"X","8","X"),
						
			expectedBoard(  "X","2","3",
							"4","O","6",
							"X","O","X"),
 
			expectedBoard(  "X","2","X",
							"O","O","6",
							"X","O","X"),
 
			expectedBoard(  "X","2","X",
							"O","O","O",
							"X","O","X"),
						
							"Player 'O' won!"]
	
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
