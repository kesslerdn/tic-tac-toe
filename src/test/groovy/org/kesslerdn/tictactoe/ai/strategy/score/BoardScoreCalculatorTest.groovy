package org.kesslerdn.tictactoe.ai.strategy.score

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position


class BoardScoreCalculatorTest extends GroovyTestCase {

	private BoardCalculator calculator
	private RowCalculator rowCalculator
	private Board board
	private static final Mark COMPUTER_MARK = Mark.O
	private static final Mark HUMAN_MARK = Mark.X
	private static final Mark OPEN = null
	List<List<Position>> rows
	
	@Before
	void setUp(){
		rows = [[],[]]
		board = [getRows:{rows}] as Board
		rowCalculator = [calculate:{a,b -> 1}] as RowCalculator
		calculator = new BoardScoreCalculator(rowCalculator: rowCalculator)
	}
	
	@Test
	void testCalculate_FirstTurnWithCenterPositionOpen_TrialPosition5(){
		assert rows.size() == calculator.calculate(board, new TrialPosition(index:1, mark: Mark.O))
	}
}
