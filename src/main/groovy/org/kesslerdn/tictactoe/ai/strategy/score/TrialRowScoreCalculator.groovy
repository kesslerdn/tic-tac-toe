package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{
	
	
	private static final weightMap = [(-3):-100, (-2): -10, (-1): -1, 0:0, 1:10, 2:100, 3:1000]
	@Resource private MarkUtil markUtil
	@Resource private PositionUtil positionUtil

	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		Mark mark = trialPosition.mark
		Mark opposingMark= markUtil.retrieveOpponentMark(trialPosition.mark)
		
		Integer score = 0
		List<Position> openPositions = positions.findAll{it.mark == null}
		List<Position> opposingPositions = positions.findAll{it.mark && it.mark == opposingMark}
		List<Position> playerPositions = positions.findAll{it.mark && it.mark == mark}
		if(isFirstOpposingPlay(playerPositions, opposingPositions) && opposingPositions[0].index != 5 && trialPosition.index == 5){
			score = 100000
		}else if (isFirstOpposingPlay(playerPositions, opposingPositions) && opposingPositions[0].index == 5 && trialPosition.index == 3){
			score = 100000
		}else{
			score = calculateScore(openPositions, playerPositions, opposingPositions, trialPosition)
		}
		score
	}
	
	private Boolean isFirstOpposingPlay(List<Position> playerPositions, List<Position> opposingPositions){
		opposingPositions.size() == 1 && playerPositions.empty
	}

	private Integer calculateScore(List<Position> openPositions, List<Position> playerPositions, List<Position> opposingPositions, Position trialPosition){
		Integer score = 0
		score = 1 * weightMap[playerPositions.size()]
		if(isFirstOpposingPlay(playerPositions, opposingPositions)){
			score += 5
		}
		if(positionUtil.evenCount(opposingPositions) > positionUtil.oddCount(opposingPositions) && positionUtil.isOdd(trialPosition)){
			score += 5
		}else if(positionUtil.oddCount(opposingPositions) > positionUtil.evenCount(opposingPositions) && positionUtil.isEven(trialPosition)){
			score += 5
		}
		
		if(opposingPositions.size() == 2){
			score = 100000
		}
		if(playerPositions.size() > 0 && opposingPositions.size() > 0){
			score = 0
		}
		
		if(!openPositions.collect{it.index}.contains(trialPosition.index)){
			score = 0
		}
		score
	}
}