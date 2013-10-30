package org.kesslerdn.tictactoe.ai

import org.junit.Test

class StrategicPositionCounterFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		StrategicPositionCounter first = new StrategicPositionCounterFactory().create()
		StrategicPositionCounter second = new StrategicPositionCounterFactory().create()
		
		assertNotNull(first)
		assertNotNull(second)
		assertNotSame(first, second)
	}
}
