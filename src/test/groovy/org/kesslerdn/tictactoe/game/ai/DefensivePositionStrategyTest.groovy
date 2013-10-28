package org.kesslerdn.tictactoe.game.ai

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class DefensivePositionStrategyTest extends GroovyTestCase {

	private List<Position> firstRow
	private List<Position> secondRow

	@Mock RowAnalyzer rowAnalyzer
	@Mock PositionCounter counter
	@Mock Board board
	@InjectMocks PositionStrategy strategy = new DefensivePositionStrategy()
	
	
	@Before
	public void setUp(){
		List<List<Position>> rows = []
		firstRow = [TestPosition.newInstanceX()]
		rows << firstRow
		secondRow = [TestPosition.newInstanceO()]
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
		when(rowAnalyzer.isVulnerable(Mark.X, Mark.O, firstRow)).thenReturn(true)
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, firstRow)).thenReturn([1, 3])
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, secondRow)).thenReturn([2])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isVulnerable(Mark.X, Mark.O, firstRow)
		verify(rowAnalyzer).openPositions(Mark.X, Mark.O, firstRow)
		verify(counter, times(4)).add(1)
		verify(counter, times(4)).add(3)
	}

	@Test
	void testFindPosition_secondRow(){
		when(rowAnalyzer.isVulnerable(Mark.X, Mark.O, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(Mark.X, Mark.O, secondRow)).thenReturn(true)
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, firstRow)).thenReturn([1, 3])
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, secondRow)).thenReturn([2])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isVulnerable(Mark.X, Mark.O, firstRow)
		verify(rowAnalyzer).isVulnerable(Mark.X, Mark.O, secondRow)
		verify(rowAnalyzer).openPositions(Mark.X, Mark.O, secondRow)
		verify(counter, times(4)).add(2)
	}

	@Test
	void testFindPosition_Neither(){
		when(rowAnalyzer.isVulnerable(Mark.X, Mark.O, firstRow)).thenReturn(false)
		when(rowAnalyzer.isVulnerable(Mark.X, Mark.O, secondRow)).thenReturn(false)
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, firstRow)).thenReturn([1])
		when(rowAnalyzer.openPositions(Mark.X, Mark.O, secondRow)).thenReturn([2])
		
		strategy.addPositions(board, counter)
		
		verify(rowAnalyzer).isVulnerable(Mark.X, Mark.O, firstRow)
		verify(rowAnalyzer).isVulnerable(Mark.X, Mark.O, secondRow)
		verifyZeroInteractions(counter)
	}
}
