package org.kesslerdn.tictactoe.game.ai

import java.util.Map.Entry

class StrategicPositionCounter implements PositionCounter{

	private List<String> positions = []
	
	@Override
	public void add(String position) {
		positions << position
	}

	@Override
	public String largest() {
		Map<String, Integer> countMap = positions.countBy{it}
		Entry maxEntry = countMap.max{ a, b -> a.value.compareTo(b.value)}
		return maxEntry.key;
	}

	@Override
	public Boolean isEmpty() {
		return positions.isEmpty();
	}

}
