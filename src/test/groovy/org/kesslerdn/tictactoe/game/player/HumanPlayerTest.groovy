package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class HumanPlayerTest extends GroovyTestCase {
	static final Mark MARK = Mark.X
	static final String USER_PROMPT = 'please select a position'
	static final String DISPLAY_OUTPUT = "display"
	static final Integer POSITION = 1

	@Mock private Board board
	@Mock private GameControl gameControl
	@InjectMocks private HumanPlayer player = new HumanPlayer(mark: Mark.X)
	
	@Test
	public void testPlay(){
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(board.isOpen(POSITION)).thenReturn(true)
		when(gameControl.request(anyString())).thenReturn(POSITION)
		
		InOrder inOrder = inOrder(gameControl, board)
		
		player.play(board)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK $USER_PROMPT")
		inOrder.verify(board).isOpen(POSITION)
		inOrder.verify(board).mark(POSITION, MARK)
	}
	
	
	@Test
	public void testPlay_SamePositionTwice(){
		Integer takenPosition = 2
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(board.isOpen(takenPosition)).thenReturn(false)
		when(board.isOpen(POSITION)).thenReturn(true)
		when(gameControl.request(anyString())).thenReturn(takenPosition, POSITION)
		
		InOrder inOrder = inOrder(gameControl, board)
		
		player.play(board)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK $USER_PROMPT")
		inOrder.verify(board).isOpen(takenPosition)
		inOrder.verify(gameControl).status("This is an invalid move.")
		inOrder.verify(gameControl).request("Player $MARK $USER_PROMPT")
		inOrder.verify(board).isOpen(POSITION)
		inOrder.verify(board).mark(POSITION, MARK)
	}

}
