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
class CenterPositionStrategyTest extends GroovyTestCase {

	static final String MARK = "X"
	static final String OPPOSING_MARK = "Y"

	private List<Position> positions

	@Mock RowAnalyzer rowAnalyzer
	@Mock Board board
	@Mock PositionCounter counter
	@InjectMocks PositionStrategy strategy = new CenterPositionStrategy(mark:MARK, opposingMark:OPPOSING_MARK)
	
	@Before
	public void setUp(){
		positions = [new TestPosition("1"), new TestPosition("2"), new TestPosition("3"),
					new TestPosition("4"), new TestPosition("5"), new TestPosition("6"),
					new TestPosition("7"), new TestPosition("8"), new TestPosition("9"),]
		when(board.getPositions()).thenReturn(positions)
	}
	
	@Test
	void testAddPosition_ReturnsSamePositionCounter(){	
		PositionCounter actualCounter = strategy.addPositions(board, counter)
		assertSame(actualCounter, counter)
	}
	
	@Test
	void testAddPosition(){	
		PositionCounter actualCounter = strategy.addPositions(board, counter)
		verify(counter).add("5")
	}
	
	@Test
	void testAddPosition_CenterFilled(){	
		positions[4] = new TestPosition(OPPOSING_MARK)
		PositionCounter actualCounter = strategy.addPositions(board, counter)
		verifyZeroInteractions(counter)
	}
}
