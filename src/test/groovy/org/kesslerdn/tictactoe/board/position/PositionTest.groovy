package org.kesslerdn.tictactoe.board.position;

import org.kesslerdn.tictactoe.board.position.CenterPosition;
import org.kesslerdn.tictactoe.board.position.EndPosition;
import org.kesslerdn.tictactoe.board.position.Position;
import org.kesslerdn.tictactoe.board.position.StartPosition;

import groovy.util.GroovyTestCase

public class PositionTest extends GroovyTestCase{

	void testStartPosition(){
		Position position = new StartPosition("1");
		assert "|1|" == position.write();
	}

	void testCenterPosition(){
		Position position = new CenterPosition("1");
		assert "1" == position.write();
	}

	void testEndPosition(){
		Position position = new EndPosition("1");
		assert '''|1|
''' == position.write();
	}
}
