package org.kesslerdn.tictactoe.board

import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark

class TicTacToeBoardTest extends GroovyTestCase {

	void testStart_WithoutPositions() {
		Board board = new TicTacToeBoard()
		assert '' == board.display()
	}
	
	void testStart_WithPositions(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstanceX(1),
			TestPosition.newInstanceO(2),
			TestPosition.newInstanceX(3)])
		
		assert 'test 1:X,test 2:O,test 3:X,' == board.display()
	}
	
	void testIsOpen_WithPositions(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1),
			TestPosition.newInstance(2),
			TestPosition.newInstance(3)])
		assert board.isOpen(2)
	}

	void testStart_MarkPosition(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1),
			TestPosition.newInstance(2),
			TestPosition.newInstance(3)])
		
		assert 'test 1:null,test 2:null,test 3:null,' == board.display()
		board.mark(2, Mark.X)
		assert 'test 1:null,test 2:X,test 3:null,' == board.display()
		
	}
	
	
	void testIsOpen_WithOutPositions(){
		Board board = new TicTacToeBoard(positions:[TestPosition.newInstance(1),
			TestPosition.newInstance(2),
			TestPosition.newInstance(3)])
		assert false == board.isOpen(7)
	}
}
