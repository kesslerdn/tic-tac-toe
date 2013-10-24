package org.kesslerdn.tictactoe.view;

import javax.annotation.Resource

import org.springframework.stereotype.Component

@Component
public class ConsoleGameControl implements GameControl {

	@Resource private BufferedReader bufferedReader
	
	@Override
	public String request(String message) {
		print "$message:"
		bufferedReader.readLine()
	}

	@Override
	public void status(String message) {
		println message
	}

}