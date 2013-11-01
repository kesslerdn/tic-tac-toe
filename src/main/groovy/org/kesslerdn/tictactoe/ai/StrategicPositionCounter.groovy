package org.kesslerdn.tictactoe.ai

import java.util.Map.Entry

class StrategicPositionCounter implements PositionCounter{

	private List<Integer> positions = []
	
	@Override
	public void add(int position) {
		positions << position
	}

	@Override
	public int largest() {
		Map<String, Integer> countMap = positions.countBy{it}
		Entry maxEntry = largestPositionCount(countMap)
		return maxEntry.key;
	}

	@Override
	public boolean isEmpty() {
		return positions.isEmpty();
	}

	private Entry largestPositionCount(Map<String,Integer> countMap){
		countMap.max{ a, b -> a.value.compareTo(b.value)}
	}
}
