package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.view.GameControl

class HumanPlayerTest extends GroovyTestCase {
	static final Mark MARK = Mark.X
	static final String USER_PROMPT = 'please select a position'
	static final String DISPLAY_OUTPUT = "display"
	static final int POSITION = 1

	private Board board
	private GameControl gameControl
	private HumanPlayer player
	private int statusIndex
	private int isOpenIndex
	private def isOpenAnswers
	
	@Before
	void setUp(){
		
		isOpenIndex = 0
		statusIndex = 0
		board = [display:{DISPLAY_OUTPUT}, 
			isOpen:{a -> isOpenAnswers[isOpenIndex++]}, 
			mark:{a, b -> assert a == 1 ;assert b == MARK}] as Board
	}
	
	@Test
	void testPlay_Invalid(){
		isOpenAnswers  = [false, true]
		def messages = [DISPLAY_OUTPUT, "This is an invalid move."]
		GameControl gameControl = [status:{a -> assert a == messages[statusIndex++]},
									request:{a -> assert "Player X please select a position" == a ;1}] as GameControl
		player = new HumanPlayer(mark: MARK, gameControl:gameControl)
		
		player.play(board)
	}
	
	@Test
	void testPlay_Valid(){
		isOpenAnswers  = [true]
		def messages = [DISPLAY_OUTPUT]
		GameControl gameControl = [status:{a -> assert a == messages[statusIndex++]},
									request:{a -> assert "Player X please select a position" == a ;1}] as GameControl
		player = new HumanPlayer(mark: MARK, gameControl:gameControl)
		
		player.play(board)
	}
}

