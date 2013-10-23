package org.kesslerdn.tictactoe.view.io

class BufferedReaderFactory {

	static BufferedReader create(){
		new BufferedReader(new InputStreamReader(System.in))
	}
}
