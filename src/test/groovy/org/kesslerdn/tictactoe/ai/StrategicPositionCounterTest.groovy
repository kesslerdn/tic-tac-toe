package org.kesslerdn.tictactoe.ai

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.ai.PositionCounter
import org.kesslerdn.tictactoe.ai.StrategicPositionCounter

class StrategicPositionCounterTest extends GroovyTestCase {

	private PositionCounter counter
	
	@Before
	void setUp(){
		counter = new StrategicPositionCounter()
	}
	
	@Test
	void testIsEmpty_True(){
		assert counter.isEmpty()
	}
	
	@Test
	void testIsEmpty_False(){
		counter.add(1)
		assert counter.isEmpty() == false
	}
	
	@Test
	void testLargest(){
		counter.add(1)
		assert 1 == counter.largest()
	}
	
	@Test
	void testLargest_MultipleEntries(){
		counter.add(1)
		counter.add(2)
		counter.add(1)
		counter.add(3)
		counter.add(2)
		counter.add(3)
		counter.add(3)
		counter.add(4)
		assert 3 == counter.largest()
	}
	
	
	@Test
	void testLargest_Tie(){
		counter.add(1)
		counter.add(2)
		counter.add(1)
		counter.add(2)
		counter.add(1)
		counter.add(2)
		counter.add(3)
		assert 1 == counter.largest()
	}

}
