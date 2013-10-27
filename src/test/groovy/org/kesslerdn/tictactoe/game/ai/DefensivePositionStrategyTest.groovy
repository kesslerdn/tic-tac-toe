package org.kesslerdn.tictactoe.game.ai

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class DefensivePositionStrategyTest extends GroovyTestCase {

	static final String MARK = "X"
	static final String OPPOSING_MARK = "Y"

	private List<Position> firstRow
	private List<Position> secondRow

	@Mock RowAnalyzer rowAnalyzer
	@Mock Board board
	@InjectMocks PositionStrategy strategy = new DefensivePositionStrategy(mark:MARK, opposingMark:OPPOSING_MARK)
	
	
	@Before
	public void setUp(){
		List<List<Position>> rows = []
		firstRow = [new TestPosition("A")]
		rows << firstRow
		secondRow = [new TestPosition("B")]
		rows << secondRow
		
		when(board.getRows()).thenReturn(rows)
	}
	
	@Test
	void testFindPosition_firstRow(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(true)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
		
		String position = strategy.findPosition(board)
		
		assert "1" == position
		verify(rowAnalyzer).isVulnerable(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).firstOpenPosition(OPPOSING_MARK, MARK, firstRow)
	}
	
	@Test
	void testIsValid_firstRow(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(true)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
		
		assert strategy.isValid(board)
	}

	@Test
	void testFindPosition_secondRow(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(true)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
		
		String position = strategy.findPosition(board)
		
		assert "2" == position
		verify(rowAnalyzer).isVulnerable(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).isVulnerable(OPPOSING_MARK, MARK, secondRow)
		verify(rowAnalyzer).firstOpenPosition(OPPOSING_MARK, MARK, secondRow)
	}
	
	@Test
	void testIsValid_secondRow(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(true)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
				
		assert strategy.isValid(board)
	}

	@Test
	void testFindPosition_Neither(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(false)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
		
		String position = strategy.findPosition(board)
		
		assert position == null
		verify(rowAnalyzer).isVulnerable(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).isVulnerable(OPPOSING_MARK, MARK, secondRow)
	}

	@Test
	void testIsValid_Neither(){
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(OPPOSING_MARK, MARK, secondRow)).thenReturn(false)
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, firstRow)).thenReturn("1")
		when(rowAnalyzer.firstOpenPosition(OPPOSING_MARK, MARK, secondRow)).thenReturn("2")
		
		assert strategy.isValid(board) == false
	}
}
