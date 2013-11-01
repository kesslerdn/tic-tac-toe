package org.kesslerdn.tictactoe.game.position

import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.position.CenterPosition
import org.kesslerdn.tictactoe.game.position.EndPosition
import org.kesslerdn.tictactoe.game.position.StartPosition

class PositionTest extends GroovyTestCase{

	void testStartPosition_NoMark(){
		Position position = new StartPosition(index:1, mark:null)
		assert "|1|" == position.write()
	}
	
	void testStartPosition_WithMark(){
		Position position = new StartPosition(index:1, mark:Mark.X)
		assert "|X|" == position.write()
	}

	void testCenterPosition_NoMark(){
		Position position = new CenterPosition(index:1, mark:null)
		assert "1" == position.write()
	}
	
	void testCenterPosition_WithMark(){
		Position position = new CenterPosition(index:1, mark:Mark.X)
		assert "X" == position.write()
	}

	void testEndPosition_WithoutMark(){
		Position position = new EndPosition(index:1, mark:null)
		assert '''|1|
''' == position.write()
	}

	void testEndPosition_WithMark(){
		Position position = new EndPosition(index:1, mark:Mark.X)
		assert '''|X|
''' == position.write()
	}
}
