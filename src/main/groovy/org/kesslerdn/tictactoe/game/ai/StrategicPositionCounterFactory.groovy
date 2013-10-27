package org.kesslerdn.tictactoe.game.ai

class StrategicPositionCounterFactory implements PositionCounterFactory {

	@Override
	public PositionCounter create() {
		new StrategicPositionCounter()
	}

}
