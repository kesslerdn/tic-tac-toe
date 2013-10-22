package org.kesslerdn.tictactoe.board.position


class CenterPosition implements Position{
	String value;

	CenterPosition(String value){
		this.value = value;
	}

	
	@Override
	public String write() {
		"$value"
	}
}
