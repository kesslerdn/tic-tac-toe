package org.kesslerdn.tictactoe.game.ai

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.TestPosition

class ThreePositionRowAnalyzerTest extends GroovyTestCase {
	
	private ThreePositionRowAnalyzer rowAnalyzer
	@Before
	public void setUp(){
		rowAnalyzer = new ThreePositionRowAnalyzer()
	}
	
	@Test
	public void testIsVulnerable_True_FirstTwo(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition("A"), new TestPosition("")])
	}
	
	@Test
	public void testFirstOpenPosition_FirstTwo(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, "A"), new TestPosition(2, "A"), new TestPosition(3, "")])
		assert 3 == openPosition
	}

	@Test
	public void testIsVulnerable_True_LastTwo(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition(""), new TestPosition("A"), new TestPosition("A")])
	}
	
	@Test
	public void testFirstOpenPosition_LastTwo(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, ""), new TestPosition(2, "A"), new TestPosition(3, "A")])
		assert 1 == openPosition
	}

	@Test
	public void testIsVulnerable_True_FirstAndLast(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition(""), new TestPosition("A")])
	}
	
	@Test
	public void testFirstOpenPosition_FirstAndLast(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, ""), new TestPosition(2, "A"), new TestPosition(3, "A")])
		assert 1 == openPosition
	}

	@Test
	public void testIsVulnerable_False_All(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition("A"), new TestPosition("A")]) == false
	}
	
	@Test
	public void testFirstOpenPosition_All(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, "A"), new TestPosition(2, "A"), new TestPosition(3, "A")])
		assert null == openPosition
	}

	@Test
	public void testIsVulnerable_False_Mixed(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition("B"), new TestPosition("")]) == false
	}
	
	@Test
	public void testFirstOpenPosition_Mixed(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, "A"), new TestPosition(2, "B"), new TestPosition(3, "")])
		assert 3 == openPosition
	}

	@Test
	public void testIsVulnerable_False_TwoEmpty(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition(""), new TestPosition("")]) == false
	}
	
	@Test
	public void testFirstOpenPosition_TwoEmpty(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, "A"), new TestPosition(2, ""), new TestPosition(3, "")])
		assert 2 == openPosition
	}

	@Test
	public void testIsVulnerable_False_AllEmpty(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("A"), new TestPosition(""), new TestPosition("")]) == false
	}
	
	@Test
	public void testFirstOpenPosition_AllEmpty(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, ""), new TestPosition(2, ""), new TestPosition(3, "")])
		assert 1 == openPosition
	}

	@Test
	public void testIsVulnerable_False_NoMatchingMark(){
		assert rowAnalyzer.isVulnerable("A", [new TestPosition("Z"), new TestPosition("Z"), new TestPosition("Z")]) == false
	}
	
	@Test
	public void testFirstOpenPosition_NoMatchingMark(){
		Integer openPosition = rowAnalyzer.firstOpenPosition("A", "B", [new TestPosition(1, "Z"), new TestPosition(2, "Z"), new TestPosition(3, "Z")])
		assert 1 == openPosition
	}
}
