package org.kesslerdn.tictactoe.util

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class PositionUtil {
	
	Boolean areOppositeCornersMarked(List<Position> positions, Mark mark){
		List<Position> matching = positions.findAll{it.mark == mark}
		List<Integer> locations = matching.collect{it.index}
		(locations.contains(1) && locations.contains(9)) || (locations.contains(3) && locations.contains(7))
	}
	
	Boolean isEven(Position position){
		position.index % 2 == 0
	}
	
	Boolean isOdd(Position position){
		!isEven(position)
	}
	
	Integer evenCount(List<Position> positions){
		positions.count{isEven(it)}
	}
	
	Integer oddCount(List<Position> positions){
		positions.count{isOdd(it)}
	}
}