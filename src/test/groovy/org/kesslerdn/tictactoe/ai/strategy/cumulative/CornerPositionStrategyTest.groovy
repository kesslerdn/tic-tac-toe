package org.kesslerdn.tictactoe.ai.strategy.cumulative

import static org.junit.Assert.*
import static org.mockito.Mockito.*

import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.ai.PositionCounter
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class CornerPositionStrategyTest extends GroovyTestCase {

	private List<Position> positions

	@Mock Board board
	@Mock PositionCounter counter
	@InjectMocks PositionStrategy strategy = new CornerPositionStrategy()
	
	@Before
	public void setUp(){
		positions = [TestPosition.newInstance(1), TestPosition.newInstance(2), TestPosition.newInstance(3),
					TestPosition.newInstance(4), TestPosition.newInstance(5), TestPosition.newInstance(6),
					TestPosition.newInstance(7), TestPosition.newInstance(8), TestPosition.newInstance(9)]
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
		verify(counter).add(1)
		verify(counter).add(3)
		verify(counter).add(7)
		verify(counter).add(9)
	}
	
	@Test
	void testIsValid_leftCornerTaken(){
		positions[0] = TestPosition.newInstanceO()
		strategy.addPositions(board, counter)
		verify(counter).add(3)
		verify(counter).add(7)
		verify(counter).add(9)
	}
	
	@Test
	void testFindPosition_topCornersTaken(){
		positions[0] = TestPosition.newInstanceO()
		positions[2] = TestPosition.newInstanceO()
		strategy.addPositions(board, counter)
		verify(counter).add(7)
		verify(counter).add(9)
	}
	
	@Test
	void testFindPosition_allButBottomRightTaken(){
		positions[0] = TestPosition.newInstanceO()
		positions[2] = TestPosition.newInstanceO()
		positions[6] = TestPosition.newInstanceO()
		strategy.addPositions(board, counter)
		verify(counter).add(9)
	}
}
