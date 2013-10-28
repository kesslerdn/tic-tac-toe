package org.kesslerdn.tictactoe.ai.strategy.cumulative

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.ai.PositionCounter;
import org.kesslerdn.tictactoe.ai.PositionCounterFactory;
import org.kesslerdn.tictactoe.ai.strategy.PositionLocator;
import org.kesslerdn.tictactoe.ai.strategy.cumulative.StrategicPositionLocator;
import org.kesslerdn.tictactoe.board.Board
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class StrategicPositionLocatorTest extends GroovyTestCase {

	static final Integer FIRST_POSITION = 1
	
	@Mock PositionStrategy firstStrategy
	@Mock PositionStrategy secondStrategy
	@Mock PositionStrategy thirdStrategy
	@Mock PositionCounter counter
	@Mock PositionCounterFactory positionCounterFactory
	@Mock Board board
	
	PositionLocator positionLocator
	
	@Before
	void setUp(){
		when(counter.largest()).thenReturn(FIRST_POSITION)
		when(positionCounterFactory.create()).thenReturn(counter)
		
		positionLocator = new StrategicPositionLocator(
		positionStrategies:[firstStrategy, secondStrategy, thirdStrategy],
		positionCounterFactory: positionCounterFactory)
	}
	
	@Test
	void testLocate(){
		assert FIRST_POSITION == positionLocator.locate(board)
		
		verify(firstStrategy).addPositions(board, counter)
		verify(secondStrategy).addPositions(board, counter)
		verify(thirdStrategy).addPositions(board, counter)
	}
}
