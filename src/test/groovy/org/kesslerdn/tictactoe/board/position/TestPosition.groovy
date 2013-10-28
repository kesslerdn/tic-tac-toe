package org.kesslerdn.tictactoe.board.position

import org.kesslerdn.tictactoe.game.player.Mark

class TestPosition implements Position {

	Mark mark;
	Integer index
	
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

	public static newInstanceX(Integer index){
		new TestPosition(index:index, mark:Mark.X)
	}
	
	public static newInstanceO(Integer index){
		new TestPosition(index:index, mark:Mark.O)
	}
	
	public static newInstance(Integer index){
		new TestPosition(index:index)
	}
	
	public static newInstance(Integer index, Mark mark){
		new TestPosition(index:index, mark:mark)
	}

}