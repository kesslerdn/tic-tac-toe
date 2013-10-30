package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*
import static org.mockito.Mockito.*
import groovy.util.GroovyTestCase

import java.util.List

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.score.ScoreCalculator;
import org.kesslerdn.tictactoe.ai.strategy.score.TrialPosition;
import org.kesslerdn.tictactoe.ai.strategy.score.TrialRowScoreCalculator;
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark


class TrialRowScoreCalculatorTest extends GroovyTestCase {

	ScoreCalculator calculator
	private static final Mark COMPUTER_MARK = Mark.O;
	private static final Mark HUMAN_MARK = Mark.X;
	private static final Mark OPEN = null;
	private static final int NOT_IN_ROW = 4

	static final int FIRST_POSITION = 1
	static final int SECOND_POSITION = 2
	static final int THIRD_POSITION = 3;
	
	@Before
	void setUp(){
		calculator = new TrialRowScoreCalculator();
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenOpenOpen(){
		assert 0 == calculator.calculate(createRow(OPEN, OPEN, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanOpenOpen(){
		assert 0 == calculator.calculate(createRow(HUMAN_MARK, OPEN, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerOpenOpen(){
		assert 1 == calculator.calculate(createRow(COMPUTER_MARK, OPEN, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerComputerOpen(){
		assert 10 == calculator.calculate(createRow(COMPUTER_MARK, COMPUTER_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanComputerOpen(){
		assert 0 == calculator.calculate(createRow(HUMAN_MARK, COMPUTER_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenComputerOpen(){
		assert 1 == calculator.calculate(createRow(OPEN, COMPUTER_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanHumanOpen(){
		assert -10 == calculator.calculate(createRow(HUMAN_MARK, HUMAN_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerHumanOpen(){
		assert 0 == calculator.calculate(createRow(COMPUTER_MARK, HUMAN_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenHumanOpen(){
		assert -1 == calculator.calculate(createRow(OPEN, HUMAN_MARK, OPEN), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerComputerComputer(){
		assert 100 == calculator.calculate(createRow(COMPUTER_MARK, COMPUTER_MARK, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenComputerComputer(){
		assert 10 == calculator.calculate(createRow(OPEN, COMPUTER_MARK, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerOpenComputer(){
		assert 10 == calculator.calculate(createRow(COMPUTER_MARK, OPEN, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanHumanComputer(){
		assert 0 == calculator.calculate(createRow(HUMAN_MARK, HUMAN_MARK, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenHumanComputer(){
		assert 0 == calculator.calculate(createRow(OPEN, HUMAN_MARK, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanOpenComputer(){
		assert 0 == calculator.calculate(createRow(HUMAN_MARK, OPEN, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	@Test
	void testCalculate_WithoutTrialPosition_OpenOpenComputer(){
		assert 1 == calculator.calculate(createRow(OPEN, OPEN, COMPUTER_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanHumanHuman(){
		assert -99 == calculator.calculate(createRow(HUMAN_MARK, HUMAN_MARK, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_HumanOpenHuman(){
		assert -9 == calculator.calculate(createRow(HUMAN_MARK, OPEN, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenHumanHuman(){
		assert -10 == calculator.calculate(createRow(OPEN, HUMAN_MARK, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerComputerHuman(){
		assert 0 == calculator.calculate(createRow(COMPUTER_MARK, COMPUTER_MARK, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenComputerHuman(){
		assert 0 == calculator.calculate(createRow(OPEN, COMPUTER_MARK, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	@Test
	void testCalculate_WithoutTrialPosition_ComputerOpenHuman(){
		assert 0 == calculator.calculate(createRow(COMPUTER_MARK, OPEN, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	
	@Test
	void testCalculate_WithoutTrialPosition_OpenOpenHuman(){
		assert 0 == calculator.calculate(createRow(OPEN, OPEN, HUMAN_MARK), createTrialPosition(NOT_IN_ROW))
	}
	
	
	@Test
	void testCalculate_FirstTrialPosition_OpenOpenOpen(){
		assert 1 == calculator.calculate(createRow(OPEN, OPEN, OPEN), createTrialPosition(FIRST_POSITION))
	}
	
	@Test
	void testCalculate_SecondTrialPosition_ComputerOpenOpen(){
		assert 10 == calculator.calculate(createRow(COMPUTER_MARK, OPEN, OPEN), createTrialPosition(SECOND_POSITION))
	}
	
	@Test
	void testCalculate_SecondTrialPosition_ComputerComputerOpen(){
		assert 100 == calculator.calculate(createRow(COMPUTER_MARK, COMPUTER_MARK, OPEN), createTrialPosition(THIRD_POSITION))
	}


	private List<Position> createRow(Mark first, Mark second, Mark third){
		[TestPosition.newInstance(FIRST_POSITION, first),
			TestPosition.newInstance(SECOND_POSITION, second),
			TestPosition.newInstance(THIRD_POSITION, third)]
	}
	
	private TrialPosition createTrialPosition(Integer index){
		new TrialPosition(index:index, mark: Mark.O)
	}
}
