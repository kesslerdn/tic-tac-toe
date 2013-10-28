package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.ai.PositionLocator;
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class ComputerPlayerTest extends GroovyTestCase {
	static final Mark MARK = Mark.O
	static final String USER_PROMPT = 'please select a position'
	static final String DISPLAY_OUTPUT = "display"
	static final Integer FIRST_POSITION = 1
	static final Integer SECOND_POSITION = 2
	
	private List<Position> firstRow
	private List<Position> secondRow
	
	@Mock private Board board
	@Mock private GameControl gameControl
	@Mock private PositionLocator positionLocator
	@InjectMocks private ComputerPlayer player = new ComputerPlayer()
	
	@Before
	public void setUp(){
		List<List<Position>> rows = []
		firstRow = [TestPosition.newInstanceX()]
		rows << firstRow
		secondRow = [TestPosition.newInstanceO()]
		rows << secondRow
		
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(board.getRows()).thenReturn(rows)
	}
	
	@Test
	public void testPlay(){
		when(positionLocator.locate(board)).thenReturn(FIRST_POSITION)
		
		InOrder inOrder = inOrder(gameControl, board, positionLocator)
		
		player.play(board)
		
		inOrder.verify(positionLocator).locate(board)
		inOrder.verify(gameControl).status("Player $MARK played position ${FIRST_POSITION}.")
		inOrder.verify(board).mark(FIRST_POSITION, MARK)
	}
}
