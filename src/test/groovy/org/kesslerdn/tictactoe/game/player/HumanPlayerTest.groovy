package org.kesslerdn.tictactoe.game.player

import static org.mockito.Mockito.*
import static org.junit.Assert.*

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
	static final String MARK = "X"
	static final String USER_PROMPT = 'please select a position'
	static final String DISPLAY_OUTPUT = "display"
	static final String POSITION = "1"

	@Mock private Board board
	@Mock private GameControl gameControl
	@InjectMocks private HumanPlayer player = new HumanPlayer(mark:MARK)
	
	@Test
	public void testPlay(){
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(gameControl.request(anyString())).thenReturn(POSITION)
		
		InOrder inOrder = inOrder(gameControl, board)
		
		player.play(board)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(gameControl).request("Player $MARK $USER_PROMPT")
		inOrder.verify(board).mark(POSITION, MARK)
	}
}
