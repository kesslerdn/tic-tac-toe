package org.kesslerdn.tictactoe.util

import org.kesslerdn.tictactoe.game.Mark
import org.springframework.stereotype.Component

@Component
class MarkUtil {
	Mark retrieveOpponentMark(Mark playerMark){
		if(Mark.X == playerMark){
			Mark.O
		}else{
			Mark.X
		}
	}
}
