package org.kesslerdn.tictactoe.ai.strategy.score;

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.board.position.TestPosition
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil

public class TrialRowTest extends GroovyTestCase {
	
	private TrialRow trialRow
	
	@Before
	void setUp(){
		trialRow = new TrialRow(trialPosition: new TrialPosition(mark:Mark.X), markUtil: new MarkUtil(),
			positions:[TestPosition.newInstance(1,Mark.O), TestPosition.newInstance(2,null),
				TestPosition.newInstance(3,Mark.X)], positionUtil: new PositionUtil())
	}
	
	@Test
	void testExtractMark(){
		assert Mark.X == trialRow.extractMark()
	}
	
	@Test
	void testExtractOpposingMark(){
		assert Mark.O == trialRow.extractOpposingMark()
	}
	
	@Test
	void testExtractPlayerPositions(){
		assert 3 == trialRow.extractPlayerPositions()[0].index
		
	}
	
	@Test
	void testExtractOpenPositions(){
		assert 2 == trialRow.extractOpenPositions()[0].index
	}
	
	@Test
	void testExtractOpposingPositions(){
		assert 1 == trialRow.extractOpposingPositions()[0].index
	}
}
