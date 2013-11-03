package org.kesslerdn.tictactoe.game

import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil


class TrialRow {
	
	MarkUtil markUtil
	PositionUtil positionUtil
	List<Position> positions
	Position trialPosition

	List<Position> extractPlayerPositions(){
		positionUtil.findMark(positions, extractMark())
	}
	
	List<Position> extractOpenPositions(){
		positionUtil.findMark(positions, null)
	}
	
	List<Position> extractOpposingPositions(){
		positionUtil.findMark(positions, extractOpposingMark())
	}
	
	Mark extractMark(){
		trialPosition.mark
	}
	
	Mark extractOpposingMark(){
		markUtil.retrieveOpponentMark(extractMark())
	}
}
