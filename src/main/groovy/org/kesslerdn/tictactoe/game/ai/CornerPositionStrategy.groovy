package org.kesslerdn.tictactoe.game.ai

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.Board
import org.springframework.stereotype.Component

@Component
class CornerPositionStrategy implements PositionStrategy {

	@Resource(name="secondMark") String mark
	@Resource(name="firstMark") String opposingMark
	@Resource RowAnalyzer rowAnalyzer
	
	@Override
	public PositionCounter addPositions(Board board, PositionCounter positionCounter) {
		String topLeft = board.positions[0].value
		String topRight = board.positions[2].value
		String bottomLeft = board.positions[6].value
		String bottomRight = board.positions[8].value

		String centerPosition = board.positions[4].value
		if(centerPosition != opposingMark && centerPosition != mark) positionCounter.add("5")

		String position
		if (isOpenPosition(topLeft)){
			 positionCounter.add("1")
		}
		if (isOpenPosition(topRight)){
			positionCounter.add("3")
		}
		if (isOpenPosition(bottomLeft)){
			positionCounter.add("7")
		}
		if (isOpenPosition(bottomRight)){
			positionCounter.add("9")
		}
		
		positionCounter;
	}
	
	private Boolean isOpenPosition(String value){
		value != opposingMark && value != mark
	}
}
