package org.kesslerdn.board.position

class StartPosition implements Position{
	String value;

	StartPosition(String value){
		this.value = value;
	}
	
	@Override
	public String write() {
		"|$value|"
	}
}
