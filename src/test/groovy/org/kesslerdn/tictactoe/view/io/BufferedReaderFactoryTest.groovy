package org.kesslerdn.tictactoe.view.io

import org.junit.Test

class BufferedReaderFactoryTest extends GroovyTestCase{

	@Test
	void testCreate(){
		BufferedReader bufferedReader = new BufferedReaderFactory().create()
		assertNotNull(bufferedReader)
		assertNotNull(bufferedReader.in)
	}
}
