package org.kesslerdn.tictactoe.ai


class StrategicPositionCounterFactory implements PositionCounterFactory {

	@Override
	PositionCounter create() {
		new StrategicPositionCounter()
	}

}
