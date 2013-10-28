package org.kesslerdn.tictactoe.view;

import static org.junit.Assert.*

import javax.annotation.Resource

import org.springframework.stereotype.Component


public class TestGameControl implements GameControl {

	List<String> expectedMessages = []
	private int i
	
	@Override
	public Integer request(String message) {
		throw new IllegalAccessException()
	}

	@Override
	public void status(String message) {
		assertEquals(expectedMessages[i], message)
		i++
	}

}