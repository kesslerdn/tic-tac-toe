package org.kesslerdn.board.position

class EndPosition implements Position{
	String value;

	EndPosition(String value){
		this.value = value;
	}

	@Override
	public String write() {
		"|$value|\n"
	}
}
