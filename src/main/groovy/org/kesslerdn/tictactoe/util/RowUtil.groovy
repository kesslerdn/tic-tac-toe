package org.kesslerdn.tictactoe.util

import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.springframework.stereotype.Component

@Component
class RowUtil {

	private boolean hasSameMark(List<Position> row){
		List<Mark> allMarks = row.collect{it.mark}
		List<Mark> marks = allMarks.findAll{it != null}
		List<Mark> nullMarks = allMarks.findAll{it == null}
		List<Mark> uniqueList = marks.unique(false)
		uniqueList.size() == 1 && nullMarks.empty
	}
}
