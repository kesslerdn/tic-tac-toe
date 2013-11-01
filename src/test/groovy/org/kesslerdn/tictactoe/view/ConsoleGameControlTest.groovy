package org.kesslerdn.tictactoe.view

import static org.mockito.Mockito.*

import org.junit.Test
import org.junit.runner.RunWith
import org.kesslerdn.tictactoe.view.ConsoleGameControl
import org.kesslerdn.tictactoe.view.GameControl
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner.class)
class ConsoleGameControlTest {

	@Mock private BufferedReader bufferedReader
	@InjectMocks private GameControl control = new ConsoleGameControl()
	
	@Test
	void testRequest(){
		when(bufferedReader.readLine()).thenReturn("1")
		
		assert 1 == control.request("test")
		
		verify(bufferedReader).readLine()
	}
	
	@Test
	void testRequest_InvalidAlpha(){
		when(bufferedReader.readLine()).thenReturn("U")
		
		assert -1 == control.request("test")
		
		verify(bufferedReader).readLine()
	}

}
