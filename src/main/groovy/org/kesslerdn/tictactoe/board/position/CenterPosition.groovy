package org.kesslerdn.tictactoe.board.position


class CenterPosition implements Position{
	Integer index
	String value;
	
	@Override
	public String write() {
		"$value"
	}
}
