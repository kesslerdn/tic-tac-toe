package org.kesslerdn.tictactoe.game.ai

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.strategy.rule.ThreePositionRowAnalyzer;
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark

class ThreePositionRowAnalyzerTest extends GroovyTestCase {

	private ThreePositionRowAnalyzer rowAnalyzer
	@Before
	public void setUp(){
		rowAnalyzer = new ThreePositionRowAnalyzer()
	}
	
	@Test
	public void testIsProactive_True_FirstOne(){
		assert rowAnalyzer.isProactive(Mark.X, Mark.O, createRow(Mark.X, null, null))
	}
	
	@Test
	public void testIsProactive_False_FirstTwo(){
		assert false == rowAnalyzer.isProactive(Mark.X, Mark.O, createRow(Mark.X, Mark.X, null))
	}
	
	@Test
	public void testIsProactive_True_OneOfEach(){
		assert false == rowAnalyzer.isProactive(Mark.X, Mark.O, createRow(Mark.X, null, Mark.O))
	}
	
	@Test
	public void testIsProactive_True_TwoOpponent(){
		assert false == rowAnalyzer.isProactive(Mark.X, Mark.O, createRow(Mark.X, Mark.O, Mark.O))
	}

	@Test
	public void testIsVulnerable_True_FirstTwo(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, Mark.X, null))
	}

	@Test
	public void testFirstOpenPosition_FirstTwo(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(Mark.X, Mark.X, null))
		assert [3] == openPosition
	}

	@Test
	public void testIsVulnerable_True_LastTwo(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(null, Mark.X, Mark.X))
	}
	
	@Test
	public void testFirstOpenPosition_LastTwo(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(null, Mark.X, Mark.X))
		assert [1] == openPosition
	}

	@Test
	public void testIsVulnerable_True_FirstAndLast(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, null, Mark.X))
	}
	
	@Test
	public void testFirstOpenPosition_FirstAndLast(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(null, Mark.X, Mark.X))
		assert [1] == openPosition
	}

	@Test
	public void testIsVulnerable_False_All(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, Mark.X, Mark.X)) == false
	}
	
	@Test
	public void testFirstOpenPosition_All(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(Mark.X, Mark.X, Mark.X))
		assert [] == openPosition
	}

	@Test
	public void testIsVulnerable_False_Mixed(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, Mark.O, null)) == false
	}
	
	@Test
	public void testFirstOpenPosition_Mixed(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(Mark.X, Mark.O, null))
		assert [3] == openPosition
	}

	@Test
	public void testIsVulnerable_False_TwoEmpty(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, null, null)) == false
	}
	
	@Test
	public void testFirstOpenPosition_TwoEmpty(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(Mark.X, null, null))
		assert [2, 3] == openPosition
	}

	@Test
	public void testIsVulnerable_False_AllEmpty(){
		assert rowAnalyzer.isVulnerable(Mark.X, Mark.O, createRow(Mark.X, null, null)) == false
	}
	
	@Test
	public void testFirstOpenPosition_AllEmpty(){
		List<String> openPosition = rowAnalyzer.openPositions(Mark.X, Mark.O, createRow(null, null, null))
		assert [1, 2, 3] == openPosition
	}
	
	@Test
	public void testIsAdvantagious_True_FirstOne(){
		assert rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(Mark.O, null, null))
	}
	
	@Test
	public void testIsWin_False_FirstOne(){
		assert false == rowAnalyzer.isWin(Mark.X, Mark.O, createRow(Mark.O, null, null))
	}

	@Test
	public void testIsAdvantagious_False_FirstTwo(){
		assert false == rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(Mark.O, Mark.O, null))
	}
	
	@Test
	public void testIsWin_True_FirstTwo(){
		assert rowAnalyzer.isWin(Mark.X, Mark.O, createRow(Mark.O, Mark.O, null))
	}

	@Test
	public void testIsAdvantagious_True_LastOne(){
		assert rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(null, null, Mark.O))
	}
	
	@Test
	public void testIsAdvantagious_False_LastTwo(){
		assert false == rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(null, Mark.O, Mark.O))
	}
	
	@Test
	public void testIsWin_True_LastTwo(){
		assert rowAnalyzer.isWin(Mark.X, Mark.O, createRow(null, Mark.O, Mark.O))
	}

	@Test
	public void testIsAdvantagious_True_OneOpponentMark(){
		assert rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(Mark.O, Mark.X, null)) == false
	}
	
	@Test
	public void testIsAdvantagious_True_OnlyOpponentMarks(){
		assert rowAnalyzer.isAdvantagious(Mark.X, Mark.O, createRow(Mark.X, Mark.X, null)) == false
	}

	private List<Position> createRow(Mark firstMark, Mark secondMark, Mark thirdMark){
		[TestPosition.newInstance(1, firstMark), TestPosition.newInstance(2, secondMark), TestPosition.newInstance(3, thirdMark)]
	}
}
