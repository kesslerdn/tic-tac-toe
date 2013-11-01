package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark

class TestPosition implements Position {

	Mark mark;
	int index
	
	private TestPosition(){
	}
	
	@Override
	public String write() {
		"test ${index}:${mark},"
	}
	
	public static newInstanceX(){
		new TestPosition(mark:Mark.X)
	}
	
	public static newInstanceO(){
		new TestPosition(mark:Mark.O)
	}

	public static newInstanceX(int index){
		new TestPosition(index:index, mark:Mark.X)
	}
	
	public static newInstanceO(int index){
		new TestPosition(index:index, mark:Mark.O)
	}
	
	public static newInstance(int index){
		new TestPosition(index:index)
	}
	
	public static newInstance(int index, Mark mark){
		new TestPosition(index:index, mark:mark)
	}

}