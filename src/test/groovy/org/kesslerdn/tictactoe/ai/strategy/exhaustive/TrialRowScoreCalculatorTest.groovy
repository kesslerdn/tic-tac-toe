package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import static org.junit.Assert.*
import static org.mockito.Mockito.*
import groovy.util.GroovyTestCase

import java.util.List

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark


class TrialRowScoreCalculatorTest extends GroovyTestCase {

	ScoreCalculator calculator
	private static final Mark OPEN = null;
	
	@Before
	void setUp(){
		calculator = new TrialRowScoreCalculator();
	}
	
	@Test
	void testCalculate_TrialPositionNotInRow(){
		assert 0 == calculator.calculate(createRow(OPEN, OPEN, OPEN), createTrialPosition(4, Mark.O))
	}
	
	@Test
	void testCalculate_OneOfEach(){
		assert 0 == calculator.calculate(createRow(OPEN, Mark.O, Mark.X), createTrialPosition(1, Mark.O))
	}
	
	@Test
	void testCalculate_EmptyRow(){
		assert 1 == calculator.calculate(createRow(OPEN, OPEN, OPEN), createTrialPosition(1, Mark.O))
	}
	
	@Test
	void testCalculate_OneNonMatch(){
		assert 2 == calculator.calculate(createRow(OPEN, OPEN, Mark.X), createTrialPosition(1, Mark.O))
	}
	
	@Test
	void testCalculate_OneMatch(){
		assert 3 == calculator.calculate(createRow(OPEN, Mark.O, OPEN), createTrialPosition(1, Mark.O))
	}

	@Test
	void testCalculate_TwoNonMatches(){
		assert 4 == calculator.calculate(createRow(OPEN, Mark.X, Mark.X), createTrialPosition(1, Mark.O))
	}

	@Test
	void testCalculate_TwoMatch(){
		assert 5 == calculator.calculate(createRow(OPEN, Mark.O, Mark.O), createTrialPosition(1, Mark.O))
	}

	private List<Position> createRow(Mark first, Mark second, Mark third){
		[TestPosition.newInstance(1, first),TestPosition.newInstance(2, second),TestPosition.newInstance(3, third)]
	}
	
	private TrialPosition createTrialPosition(Integer index, Mark mark){
		new TrialPosition(index:index, mark: mark)
	}
}
