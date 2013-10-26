package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.ai.RowAnalyzer
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InOrder
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class ComputerPlayerTest extends GroovyTestCase {
	static final String MARK = "X"
	static final String OPPOSING_MARK = "Y"
	static final String USER_PROMPT = 'please select a position'
	static final String DISPLAY_OUTPUT = "display"
	static final Integer FIRST_POSITION = 1
	static final Integer SECOND_POSITION = 2
	
	private List<Position> firstRow
	private List<Position> secondRow
	
	@Mock private Board board
	@Mock private RowAnalyzer rowAnalyzer
	@Mock private GameControl gameControl
	@InjectMocks private ComputerPlayer player = new ComputerPlayer(mark:MARK, opposingMark:OPPOSING_MARK)
	
	@Before
	public void setUp(){
		List<List<Position>> rows = []
		firstRow = [new TestPosition("A")]
		rows << firstRow
		secondRow = [new TestPosition("B")]
		rows << secondRow
		
		when(board.display()).thenReturn(DISPLAY_OUTPUT)
		when(board.getRows()).thenReturn(rows)
	}
	
	@Test
	public void testPlay_WithOneVulnerablePosition(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn(FIRST_POSITION)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(true)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn(SECOND_POSITION)
		
		InOrder inOrder = inOrder(gameControl, board)
		
		player.play(board)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(board).getRows()
		inOrder.verify(board).mark(SECOND_POSITION.toString(), MARK)
	}
	
	@Test
	public void testPlay_WithNoVulnerablePositions(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn(FIRST_POSITION)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(false)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn(SECOND_POSITION)
		
		InOrder inOrder = inOrder(gameControl, board)
		
		player.play(board)
		
		inOrder.verify(board).display()
		inOrder.verify(gameControl).status(DISPLAY_OUTPUT)
		inOrder.verify(board, times(2)).getRows()
		inOrder.verify(board).mark(FIRST_POSITION.toString(), MARK)
	}
}
