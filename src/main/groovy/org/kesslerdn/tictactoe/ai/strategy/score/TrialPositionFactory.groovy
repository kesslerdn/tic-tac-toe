package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.game.Mark
import org.springframework.stereotype.Component

@Component
class TrialPositionFactory {
	
	TrialPosition create(int index, Mark mark){
		new TrialPosition(index:index, mark:mark)
	}
}
