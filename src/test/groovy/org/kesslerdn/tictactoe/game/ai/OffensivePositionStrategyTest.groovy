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
class OffensivePositionStrategyTest extends GroovyTestCase {

	static final String MARK = "X"
	static final String OPPOSING_MARK = "Y"

	private List<Position> firstRow
	private List<Position> secondRow

	@Mock RowAnalyzer rowAnalyzer
	@Mock Board board
	@Mock PositionCounter counter
	@InjectMocks PositionStrategy strategy = new OffensivePositionStrategy(mark:MARK, opposingMark:OPPOSING_MARK)
	
	
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
	void testAddPosition_ReturnsSamePositionCounter(){
		PositionCounter actualCounter = strategy.addPositions(board, counter)
		assertSame(actualCounter, counter)
	}
	
	@Test
	void testFindPosition_firstRow(){
		when(rowAnalyzer.isAdvantagious(OPPOSING_MARK, MARK, firstRow)).thenReturn(true)
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, firstRow)).thenReturn(["1", "3"])
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, secondRow)).thenReturn(["2"])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isAdvantagious(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).openPositions(OPPOSING_MARK, MARK, firstRow)
		verify(counter).add("1")
		verify(counter).add("3")
	}

	@Test
	void testFindPosition_secondRow(){
		when(rowAnalyzer.isAdvantagious(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isAdvantagious(OPPOSING_MARK, MARK, secondRow)).thenReturn(true)
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, firstRow)).thenReturn(["1", "3"])
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, secondRow)).thenReturn(["2"])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isAdvantagious(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).isAdvantagious(OPPOSING_MARK, MARK, secondRow)
		verify(rowAnalyzer).openPositions(OPPOSING_MARK, MARK, secondRow)
		verify(counter).add("2")
	}

	@Test
	void testFindPosition_Neither(){
		when(rowAnalyzer.isAdvantagious(OPPOSING_MARK, MARK, firstRow)).thenReturn(false)
		when(rowAnalyzer.isAdvantagious(OPPOSING_MARK, MARK, secondRow)).thenReturn(false)
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, firstRow)).thenReturn(["1"])
		when(rowAnalyzer.openPositions(OPPOSING_MARK, MARK, secondRow)).thenReturn(["2"])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isAdvantagious(OPPOSING_MARK, MARK, firstRow)
		verify(rowAnalyzer).isAdvantagious(OPPOSING_MARK, MARK, secondRow)
		verifyZeroInteractions(counter)
	}
}
