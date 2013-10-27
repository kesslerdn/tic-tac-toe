package org.kesslerdn.tictactoe.game.ai

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.board.position.TestPosition

class ThreePositionRowAnalyzerTest extends GroovyTestCase {

	static final String OPPOSING_MARK = "A"

	static final String PLAYER_MARK = "B"

	static final String NEITHER_MARK = "Z"
	
	private ThreePositionRowAnalyzer rowAnalyzer
	@Before
	public void setUp(){
		rowAnalyzer = new ThreePositionRowAnalyzer()
	}
	
	@Test
	public void testIsVulnerable_True_FirstTwo(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, OPPOSING_MARK, ""))
	}

	@Test
	public void testFirstOpenPosition_FirstTwo(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, OPPOSING_MARK, ""))
		assert ["3"] == openPosition
	}

	@Test
	public void testIsVulnerable_True_LastTwo(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow("", OPPOSING_MARK, OPPOSING_MARK))
	}
	
	@Test
	public void testFirstOpenPosition_LastTwo(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow("", OPPOSING_MARK, OPPOSING_MARK))
		assert ["1"] == openPosition
	}

	@Test
	public void testIsVulnerable_True_FirstAndLast(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, "", OPPOSING_MARK))
	}
	
	@Test
	public void testFirstOpenPosition_FirstAndLast(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow("", OPPOSING_MARK, OPPOSING_MARK))
		assert ["1"] == openPosition
	}

	@Test
	public void testIsVulnerable_False_All(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, OPPOSING_MARK, OPPOSING_MARK)) == false
	}
	
	@Test
	public void testFirstOpenPosition_All(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, OPPOSING_MARK, OPPOSING_MARK))
		assert [] == openPosition
	}

	@Test
	public void testIsVulnerable_False_Mixed(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, PLAYER_MARK, "")) == false
	}
	
	@Test
	public void testFirstOpenPosition_Mixed(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, PLAYER_MARK, ""))
		assert ["3"] == openPosition
	}

	@Test
	public void testIsVulnerable_False_TwoEmpty(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, "", "")) == false
	}
	
	@Test
	public void testFirstOpenPosition_TwoEmpty(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, "", ""))
		assert ["2", "3"] == openPosition
	}

	@Test
	public void testIsVulnerable_False_AllEmpty(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, "", "")) == false
	}
	
	@Test
	public void testFirstOpenPosition_AllEmpty(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow("", "", ""))
		assert ["1", "2", "3"] == openPosition
	}

	@Test
	public void testIsVulnerable_False_NoMatchingMark(){
		assert rowAnalyzer.isVulnerable(OPPOSING_MARK, PLAYER_MARK, createRow(NEITHER_MARK, NEITHER_MARK, NEITHER_MARK)) == false
	}
	
	@Test
	public void testFirstOpenPosition_NoMatchingMark(){
		List<String> openPosition = rowAnalyzer.openPositions(OPPOSING_MARK, PLAYER_MARK, createRow(NEITHER_MARK, NEITHER_MARK, NEITHER_MARK))
		assert ["1", "2", "3"] == openPosition
	}
	
	@Test
	public void testIsAdvantagious_True_FirstOne(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow(PLAYER_MARK, "", ""))
	}
	
	@Test
	public void testIsAdvantagious_True_FirstTwo(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow(PLAYER_MARK, PLAYER_MARK, ""))
	}
	
	@Test
	public void testIsAdvantagious_True_LastOne(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow("", "", PLAYER_MARK))
	}
	
	@Test
	public void testIsAdvantagious_True_LastTwo(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow("", PLAYER_MARK, PLAYER_MARK))
	}

	@Test
	public void testIsAdvantagious_True_OneOpponentMark(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow(PLAYER_MARK, OPPOSING_MARK, "")) == false
	}
	
	@Test
	public void testIsAdvantagious_True_OnlyOpponentMarks(){
		assert rowAnalyzer.isAdvantagious(OPPOSING_MARK, PLAYER_MARK, createRow(OPPOSING_MARK, OPPOSING_MARK, "")) == false
	}

	private List<Position> createRow(String firstMark, String secondMark, String thirdMark){
		[new TestPosition(1, firstMark), new TestPosition(2, secondMark), new TestPosition(3, thirdMark)]
	}
}
