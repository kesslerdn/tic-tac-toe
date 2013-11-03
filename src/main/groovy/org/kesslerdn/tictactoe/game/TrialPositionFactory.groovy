package org.kesslerdn.tictactoe.game

import org.springframework.stereotype.Component

@Component
class TrialPositionFactory {
	
	List<TrialPosition> create(List<Integer> indexes, Mark mark){
		indexes.collect{index ->
			new TrialPosition(index:index, mark:mark)
		}
	}
}
