package org.kesslerdn.tictactoe.game.ai

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.board.Board
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class StrategicPositionLocatorTest extends GroovyTestCase {

	static final String FIRST_POSITION = "1"
	static final String SECOND_POSITION = "1"
	static final String THIRD_POSITION = "1"
	
	@Mock PositionStrategy firstStrategy
	@Mock PositionStrategy secondStrategy
	@Mock PositionStrategy thirdStrategy
	@Mock Board board
	
	PositionLocator positionLocator
	
	@Before
	void setUp(){
		when(firstStrategy.isValid(board)).thenReturn(false)
		when(secondStrategy.isValid(board)).thenReturn(false)
		when(thirdStrategy.isValid(board)).thenReturn(false)
		
		when(firstStrategy.findPosition(board)).thenReturn(FIRST_POSITION)
		when(secondStrategy.findPosition(board)).thenReturn(SECOND_POSITION)
		when(thirdStrategy.findPosition(board)).thenReturn(THIRD_POSITION)
		
		positionLocator = new StrategicPositionLocator(
		positionStrategies:[firstStrategy, secondStrategy, thirdStrategy])
	}
	
	@Test
	void testLocate_firstStrategy(){
		when(firstStrategy.isValid(board)).thenReturn(true)
		
		assert FIRST_POSITION == positionLocator.locate(board)
	}
	
	@Test
	void testLocate_secondStrategy(){
		when(secondStrategy.isValid(board)).thenReturn(true)
		
		assert SECOND_POSITION == positionLocator.locate(board)
	}
	
	@Test
	void testLocate_thirdStrategy(){
		when(thirdStrategy.isValid(board)).thenReturn(true)
		
		assert THIRD_POSITION == positionLocator.locate(board)
	}
	
	@Test
	void testLocate_noStrategy(){
		assert null == positionLocator.locate(board)
	}
	
	@Test
	void testLocate_firstValidStrategy(){
		when(secondStrategy.isValid(board)).thenReturn(true)
		when(thirdStrategy.isValid(board)).thenReturn(true)
		
		assert SECOND_POSITION == positionLocator.locate(board)
	}
}
