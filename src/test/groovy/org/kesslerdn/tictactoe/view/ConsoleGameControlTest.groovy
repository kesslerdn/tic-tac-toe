package org.kesslerdn.tictactoe.view

import org.junit.Test
import org.mockito.Mockito

class ConsoleGameControlTest {

	private GameControl control
	
	@Test
	void testRequest(){
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class)
		Mockito.when(bufferedReader.readLine()).thenReturn("1")
		control = new ConsoleGameControl(bufferedReader:bufferedReader)
		assert 1 == control.request("test")
	}
	
	@Test
	void testRequest_InvalidAlpha(){
		BufferedReader bufferedReader = Mockito.mock(BufferedReader.class)
		Mockito.when(bufferedReader.readLine()).thenReturn("U")
		control = new ConsoleGameControl(bufferedReader:bufferedReader)
		assert -1 == control.request("test")
	}
}
