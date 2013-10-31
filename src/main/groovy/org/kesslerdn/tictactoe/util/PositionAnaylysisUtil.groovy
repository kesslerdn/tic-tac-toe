package org.kesslerdn.tictactoe.util

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class PositionAnaylysisUtil {
	
	Boolean areOppositeCornersMarked(List<Position> positions, Mark mark){
		List<Position> matching = positions.findAll{it.mark == mark}
		List<Integer> locations = matching.collect{it.index}
		(locations.contains(1) && locations.contains(9)) || (locations.contains(3) && locations.contains(7))
	}
}