package org.kesslerdn.tictactoe.game.ai

import org.junit.Before
import org.junit.Test

class StrategicPositionCounterTest extends GroovyTestCase {

	PositionCounter counter
	
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
		counter.add("A")
		assert counter.isEmpty() == false
	}
	
	@Test
	void testLargest(){
		counter.add("A")
		assert "A" == counter.largest()
	}
	
	@Test
	void testLargest_MultipleEntries(){
		counter.add("A")
		counter.add("B")
		counter.add("A")
		counter.add("C")
		counter.add("B")
		counter.add("C")
		counter.add("C")
		counter.add("D")
		assert "C" == counter.largest()
	}
	
	
	@Test
	void testLargest_Tie(){
		counter.add("A")
		counter.add("B")
		counter.add("A")
		counter.add("B")
		counter.add("A")
		counter.add("B")
		counter.add("C")
		assert "A" == counter.largest()
	}

}
