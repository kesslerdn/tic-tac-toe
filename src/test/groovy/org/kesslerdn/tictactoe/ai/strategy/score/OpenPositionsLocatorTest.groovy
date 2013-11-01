package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.TicTacToeBoard
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.PositionUtil


class OpenPositionsLocatorTest extends GroovyTestCase {

	PositionsLocator locator
	
	@Before
	void setUp(){
		locator = new OpenPositionsLocator(positionUtil: new PositionUtil());
	}
	
	@Test
	void testLocate(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1, null),TestPosition.newInstance(2, null),TestPosition.newInstance(3, null),
			TestPosition.newInstance(4, null),TestPosition.newInstance(5, null),TestPosition.newInstance(6, null),
			TestPosition.newInstance(7, null),TestPosition.newInstance(8, null),TestPosition.newInstance(9, null)])
		assert [1,2,3,4,5,6,7,8,9] == locator.locate(board)
	}
	
	@Test
	void testLocate_SomeMarked(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1, null),TestPosition.newInstance(2, Mark.X),TestPosition.newInstance(3, null),
			TestPosition.newInstance(4, null),TestPosition.newInstance(5, Mark.O),TestPosition.newInstance(6, null),
			TestPosition.newInstance(7, null),TestPosition.newInstance(8, Mark.X),TestPosition.newInstance(9, null)])
		assert [1,3,4,6,7,9] == locator.locate(board)
	}
	
	@Test
	void testLocate_AllMarked(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1, Mark.O),TestPosition.newInstance(2, Mark.X),TestPosition.newInstance(3, Mark.O),
			TestPosition.newInstance(4, Mark.X),TestPosition.newInstance(5, Mark.O),TestPosition.newInstance(6, Mark.X),
			TestPosition.newInstance(7, Mark.O),TestPosition.newInstance(8, Mark.X),TestPosition.newInstance(9, Mark.O)])
		assert [] == locator.locate(board)
	}
}
