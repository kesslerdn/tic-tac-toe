package org.kesslerdn.tictactoe.game.position

import org.kesslerdn.tictactoe.game.Mark;
import org.kesslerdn.tictactoe.game.Position;

class TestPosition implements Position {

	Mark mark
	int index
	
	private TestPosition(){
	}
	
	@Override
	String write() {
		"test ${index}:${mark},"
	}
	
	static newInstanceX(){
		new TestPosition(mark:Mark.X)
	}
	
	static newInstanceO(){
		new TestPosition(mark:Mark.O)
	}

	static newInstanceX(int index){
		new TestPosition(index:index, mark:Mark.X)
	}
	
	static newInstanceO(int index){
		new TestPosition(index:index, mark:Mark.O)
	}
	
	static newInstance(int index){
		new TestPosition(index:index)
	}
	
	static newInstance(int index, Mark mark){
		new TestPosition(index:index, mark:mark)
	}

}