package org.kesslerdn.tictactoe.view;

import javax.annotation.Resource

import org.springframework.stereotype.Component

@Component
public class ConsoleGameControl implements GameControl {

	@Resource private BufferedReader bufferedReader
	
	@Override
	public int request(String message) {
		print "$message:"
		String response = bufferedReader.readLine()
		if(response.isInteger()){
			response.toInteger()
		}else{
			-1
		}
	}

	@Override
	public void status(String message) {
		println message
	}

}