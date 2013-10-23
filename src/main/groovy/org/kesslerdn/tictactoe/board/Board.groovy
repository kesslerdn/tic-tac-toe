package org.kesslerdn.tictactoe.board

interface Board {
	String display()
	void mark(String positionValue, String value)
}
