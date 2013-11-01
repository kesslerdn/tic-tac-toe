package org.kesslerdn.tictactoe.game

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.test.ReturnValues
import org.kesslerdn.tictactoe.view.GameControl

class FinalScoreTest extends GroovyTestCase{

	private static final String DISPLAY_OUTPUT = "display"
	private Board board
	private Score score
	private ReturnValues<Integer> scores
	private ReturnValues<String> messages
	private Tracker tracker
	private GameControl gameControl
	
	@Before
	void setUp(){
		board = [display:{DISPLAY_OUTPUT}] as Board
		tracker = [calculateScore:{a, b -> scores.next()}] as Tracker
		gameControl = [status:{a -> assert a == messages.next()}] as GameControl
	}
	
	@Test
	void testDisplay_Tie() {
		scores = new ReturnValues<Integer>([2,2])
		messages = new ReturnValues<String>([DISPLAY_OUTPUT, "This game ended in a tie!"])
		
		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
	
	@Test
	void testDisplay_PlayerO() {
		scores = new ReturnValues<Integer>([1,2])
		messages = new ReturnValues<String>([DISPLAY_OUTPUT, "Player 'O' won!"])

		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
	
	@Test
	void testDisplay_PlayerX() {
		scores = new ReturnValues<Integer>([2,1])
		messages = new ReturnValues<String>([DISPLAY_OUTPUT, "Player 'X' won!"])
		
		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
}
