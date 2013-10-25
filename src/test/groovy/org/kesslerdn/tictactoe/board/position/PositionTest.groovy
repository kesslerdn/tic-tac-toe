package org.kesslerdn.tictactoe.board.position;

import org.kesslerdn.tictactoe.board.position.CenterPosition;
import org.kesslerdn.tictactoe.board.position.EndPosition;
import org.kesslerdn.tictactoe.board.position.Position;
import org.kesslerdn.tictactoe.board.position.StartPosition;

import groovy.util.GroovyTestCase

public class PositionTest extends GroovyTestCase{

	void testStartPosition(){
		Position position = new StartPosition(value:"1");
		assert "|1|" == position.write();
	}

	void testCenterPosition(){
		Position position = new CenterPosition(value:"1");
		assert "1" == position.write();
	}

	void testEndPosition(){
		Position position = new EndPosition(value:"1");
		assert '''|1|
''' == position.write();
	}
}
