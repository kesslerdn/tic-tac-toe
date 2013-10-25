package org.kesslerdn.tictactoe.board.position

class EndPosition implements Position{
	Integer index
	String value;

	@Override
	public String write() {
		"|$value|\n"
	}
}
