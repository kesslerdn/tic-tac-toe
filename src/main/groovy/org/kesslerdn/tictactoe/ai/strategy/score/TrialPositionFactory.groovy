package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Mark
import org.springframework.stereotype.Component

@Component
class TrialPositionFactory {
	
	List<TrialPosition> create(List<Integer> indexes, Mark mark){
		indexes.collect{index ->
			new TrialPosition(index:index, mark:mark)
		}
	}
}
