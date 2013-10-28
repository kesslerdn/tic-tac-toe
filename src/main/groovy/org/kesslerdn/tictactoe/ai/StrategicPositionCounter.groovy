package org.kesslerdn.tictactoe.ai

import java.util.Map.Entry

class StrategicPositionCounter implements PositionCounter{

	private List<Integer> positions = []
	
	@Override
	public void add(Integer position) {
		positions << position
	}

	@Override
	public Integer largest() {
		Map<String, Integer> countMap = positions.countBy{it}
		Entry maxEntry = countMap.max{ a, b -> a.value.compareTo(b.value)}
		return maxEntry.key;
	}

	@Override
	public Boolean isEmpty() {
		return positions.isEmpty();
	}

}
