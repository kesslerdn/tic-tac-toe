package org.kesslerdn.tictactoe.board.position

class StartPosition implements Position{
	Integer index
	String value;
	
	@Override
	public String write() {
		"|$value|"
	}
}
