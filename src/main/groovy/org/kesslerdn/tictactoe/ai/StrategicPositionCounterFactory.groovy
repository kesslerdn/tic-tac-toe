package org.kesslerdn.tictactoe.ai


class StrategicPositionCounterFactory implements PositionCounterFactory {

	@Override
	public PositionCounter create() {
		new StrategicPositionCounter()
	}

}
