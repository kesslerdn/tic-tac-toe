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
	public String findPosition(Board board) {
		
		String topLeft = board.positions[0].value
		String topRight = board.positions[2].value
		String bottomLeft = board.positions[6].value
		String bottomRight = board.positions[8].value
		
		String position
		if (isOpenPosition(topLeft)){
			 position = "1"
		}else if (isOpenPosition(topRight)){
			position = "3"
		}else if (isOpenPosition(bottomLeft)){
			position = "7"
		}else if (isOpenPosition(bottomRight)){
			position = "9"
		}
		position
	}
	
	@Override
	public Boolean isValid(Board board) {
		findPosition(board) != null
	}
	
	private Boolean isOpenPosition(String value){
		value != opposingMark && value != mark
	}
}
