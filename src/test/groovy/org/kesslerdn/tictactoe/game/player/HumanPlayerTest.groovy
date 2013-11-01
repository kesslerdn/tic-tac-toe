package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.test.ReturnValues
import org.kesslerdn.tictactoe.view.GameControl

class HumanPlayerTest extends GroovyTestCase {
	private static final Mark MARK = Mark.X
	private static final String DISPLAY_OUTPUT = "display"
	private Board board
	private ReturnValues<Boolean> isOpenValues
	
	@Before
	void setUp(){
		board = [display:{DISPLAY_OUTPUT}, 
			isOpen:{a -> isOpenValues.next()}, 
			mark:{a, b -> assert a == 1 ;assert b == MARK}] as Board
	}
	
	@Test
	void testPlay_Invalid(){
		isOpenValues = new ReturnValues<Boolean>([false, true])
		ReturnValues<String> messages = new ReturnValues<String>([DISPLAY_OUTPUT, "This is an invalid move."])
		GameControl gameControl = [status:{a -> assert a == messages.next()},
									request:{a -> assert "Player X please select a position" == a ;1}] as GameControl
		HumanPlayer player = new HumanPlayer(mark: MARK, gameControl:gameControl)
		
		player.play(board)
	}
	
	@Test
	void testPlay_Valid(){
		isOpenValues = new ReturnValues<Boolean>([true])
		ReturnValues<String> messages = new ReturnValues<String>([DISPLAY_OUTPUT])
		GameControl gameControl = [status:{a -> assert a == messages.next()},
									request:{a -> assert "Player X please select a position" == a;1}] as GameControl
		HumanPlayer player = new HumanPlayer(mark: MARK, gameControl:gameControl)
		
		player.play(board)
	}
}

