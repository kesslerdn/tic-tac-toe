package org.kesslerdn.tictactoe.view;

public class ConsoleGameControl implements GameControl {

	@Override
	public String request(String message) {
		System.console().readline(message)
	}

	@Override
	public void status(String message) {
		println message
	}

}