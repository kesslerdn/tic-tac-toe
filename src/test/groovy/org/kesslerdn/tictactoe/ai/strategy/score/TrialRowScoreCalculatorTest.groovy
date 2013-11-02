package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.position.TestPosition
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil


class TrialRowScoreCalculatorTest extends GroovyTestCase {

	private RowCalculator calculator
	private static final Mark COMPUTER_MARK = Mark.O
	private static final Mark HUMAN_MARK = Mark.X
	private static final Mark OPEN = null
	
	@Before
	void setUp(){
		calculator = new TrialRowScoreCalculator(markUtil: new MarkUtil(), 
			positionUtil: new PositionUtil(), trialRowFactory: new TrialRowFactory(markUtil: new MarkUtil(), 
			positionUtil: new PositionUtil()), scoreCalculations: [] as SortedSet)
	}
	
	@Test
	void testCalculate_FirstTurnWithCenterPositionOpen_TrialPosition5(){
		assert 100000 == calculator.calculate(createMiddleRow(OPEN, OPEN, HUMAN_MARK), createTrialPosition(5))
	}
	
	@Test
	void testCalculate_FirstTurnWithCenterPositionOpen_NotTrialPosition5(){
		assert 0 == calculator.calculate(createMiddleRow(OPEN, OPEN, HUMAN_MARK), createTrialPosition(0))
	}

	@Test
	void testCalculate_FirstTurnWithCenterPositionTaken_TrialPosition3(){
		assert 100000 == calculator.calculate(createMiddleRow(OPEN, HUMAN_MARK, OPEN), createTrialPosition(3))
	}
	
	@Test
	void testCalculate_FirstTurnWithCenterPositionTaken_NotTrialPosition3(){
		assert 0 == calculator.calculate(createMiddleRow(OPEN, HUMAN_MARK, OPEN), createTrialPosition(0))
	}
	
	@Test
	void testCalculate_ZeroPlays(){
		assert 0 == calculator.calculate(createMiddleRow(OPEN, OPEN, OPEN), createTrialPosition(0))
	}
	
	@Test
	void testCalculate_OnePlay(){
		assert 10 == calculator.calculate(createMiddleRow(OPEN, COMPUTER_MARK, OPEN), createTrialPosition(0))
	}
	
	@Test
	void testCalculate_TwoPlays(){
		assert 100 == calculator.calculate(createMiddleRow(COMPUTER_MARK, COMPUTER_MARK, OPEN), createTrialPosition(0))
	}
	
	@Test
	void testCalculate_ThreePlays(){
		assert 1000 == calculator.calculate(createMiddleRow(COMPUTER_MARK, COMPUTER_MARK, COMPUTER_MARK), createTrialPosition(0))
	}
	
	@Test
	void testCalculate_WithTestScoreCalculation(){
		calculator.scoreCalculations = [new TestScoreCalculation()] as SortedSet
		assert TestScoreCalculation.TEST_AMOUNT == calculator.calculate(createMiddleRow(OPEN, HUMAN_MARK, OPEN), createTrialPosition(0))
	}
	
	private List<Position> createMiddleRow(Mark first, Mark second, Mark third){
		[TestPosition.newInstance(4, first),
			TestPosition.newInstance(5, second),
			TestPosition.newInstance(6, third)]
	}

	private TrialPosition createTrialPosition(int index){
		new TrialPosition(index:index, mark: Mark.O)
	}
}

class TestScoreCalculation implements TrialRowCalculation{
	static final int TEST_AMOUNT = 111
	@Override
	int compareTo(Object o) {
		return 0
	}

	@Override
	int calculate(int score, TrialRow trialRow) {
		TEST_AMOUNT
	}
}
