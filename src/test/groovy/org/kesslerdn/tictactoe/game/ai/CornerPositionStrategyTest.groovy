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

import com.google.common.base.Splitter.Strategy;

@RunWith(MockitoJUnitRunner.class)
class CornerPositionStrategyTest extends GroovyTestCase {

	static final String MARK = "X"
	static final String OPPOSING_MARK = "Y"

	private List<Position> positions

	@Mock RowAnalyzer rowAnalyzer
	@Mock Board board
	@InjectMocks PositionStrategy strategy = new CornerPositionStrategy(mark:MARK, opposingMark:OPPOSING_MARK)
	
	@Before
	public void setUp(){
		positions = [new TestPosition("1"), new TestPosition("2"), new TestPosition("3"),
					new TestPosition("4"), new TestPosition("5"), new TestPosition("6"),
					new TestPosition("7"), new TestPosition("8"), new TestPosition("9"),]
		when(board.getPositions()).thenReturn(positions)
	}

	@Test
	void testFindPosition_allAvailable(){	
		assert "1" == strategy.findPosition(board)
	}
	
	@Test
	void testIsValid_allAvailable(){
		assert strategy.isValid(board)
	}
	
	@Test
	void testFindPosition_leftCornerTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		assert "3" == strategy.findPosition(board)
	}
	
	@Test
	void testIsValid_leftCornerTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		assert strategy.isValid(board)
	}
	
	@Test
	void testFindPosition_topCornersTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		positions[2] = new TestPosition(OPPOSING_MARK)
		assert "7" == strategy.findPosition(board)
	}
	
	@Test
	void testIsValid_topCornersTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		positions[2] = new TestPosition(OPPOSING_MARK)
		assert strategy.isValid(board)
	}
	
	@Test
	void testFindPosition_allButBottomRightTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		positions[2] = new TestPosition(OPPOSING_MARK)
		positions[6] = new TestPosition(OPPOSING_MARK)
		assert "9" == strategy.findPosition(board)
	}
	
	@Test
	void testIsValid_allButBottomRightTaken(){
		positions[0] = new TestPosition(OPPOSING_MARK)
		positions[2] = new TestPosition(OPPOSING_MARK)
		positions[6] = new TestPosition(OPPOSING_MARK)
		assert strategy.isValid(board)
	}
}
