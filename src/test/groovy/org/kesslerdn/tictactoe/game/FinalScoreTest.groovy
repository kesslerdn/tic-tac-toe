package org.kesslerdn.tictactoe.game

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.view.GameControl

class FinalScoreTest extends GroovyTestCase{

	static final String DISPLAY_OUTPUT = "display"
	Board board
	Score score
	int statusIndex
	
	@Before
	void setUp(){
		statusIndex = 0
		board = [display:{DISPLAY_OUTPUT}] as Board
	}
	
	@Test
	void testDisplay_Tie() {
		def scores = [(Mark.X):2, (Mark.O):2]
		def messages = [DISPLAY_OUTPUT, "This game ended in a tie!"]
		Tracker tracker = [calculateScore:{a, b -> scores[a]}] as Tracker
		GameControl gameControl = [status:{a -> assert a == messages[statusIndex++]}] as GameControl
		
		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
	
	@Test
	void testDisplay_PlayerO() {
		def scores = [(Mark.X):1, (Mark.O):2]
		def messages = [DISPLAY_OUTPUT, "Player 'O' won!"]
		Tracker tracker = [calculateScore:{a, b -> scores[a]}] as Tracker
		GameControl gameControl = [status:{a -> assert a == messages[statusIndex++]}] as GameControl
		
		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
	
	@Test
	void testDisplay_PlayerX() {
		def scores = [(Mark.X):2, (Mark.O):1]
		def messages = [DISPLAY_OUTPUT, "Player 'X' won!"]
		Tracker tracker = [calculateScore:{a, b -> scores[a]}] as Tracker
		GameControl gameControl = [status:{a -> assert a == messages[statusIndex++]}] as GameControl
		
		score = new FinalScore(tracker:tracker, gameControl:gameControl)
		
		score.display(board)
	}
}
