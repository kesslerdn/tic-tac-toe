package org.kesslerdn.tictactoe.ai

import org.junit.Test

class StrategicPositionCounterFactoryTest extends GroovyTestCase {

	@Test
	void testCreate(){
		StrategicPositionCounterFactory factory = new StrategicPositionCounterFactory()
		StrategicPositionCounter first = factory.create()
		StrategicPositionCounter second = factory.create()
		
		assertNotNull(first)
		assertNotNull(second)
		assertNotSame(first, second)
	}
}
