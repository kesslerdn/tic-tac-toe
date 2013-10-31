package org.kesslerdn.tictactoe.ai.strategy.score

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil
import org.kesslerdn.tictactoe.util.PositionUtil
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{
	
	
	private static final weightMap = [0:0, 1:10, 2:100, 3:1000]
	@Resource private MarkUtil markUtil
	@Resource private PositionUtil positionUtil

	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		Mark mark = trialPosition.mark
		Mark opposingMark= markUtil.retrieveOpponentMark(trialPosition.mark)
		
		Integer score = 0
		List<Position> openPositions = positionUtil.findMark(positions, null)
		List<Position> opposingPositions = positionUtil.findMark(positions, opposingMark)
		List<Position> playerPositions = positionUtil.findMark(positions, mark)
		if(positionUtil.containsOnlyOpponenet(playerPositions, opposingPositions) && opposingPositions[0].index != 5 && trialPosition.index == 5){
			score = 100000
		}else if (positionUtil.containsOnlyOpponenet(playerPositions, opposingPositions) && opposingPositions[0].index == 5 && trialPosition.index == 3){
			score = 100000
		}else{
			score = calculateScore(openPositions, playerPositions, opposingPositions, trialPosition)
		}
		score
	}
	
	private Integer calculateScore(List<Position> openPositions, List<Position> playerPositions, List<Position> opposingPositions, Position trialPosition){
		Integer score = 0
		score = 1 * weightMap[playerPositions.size()]
		if(positionUtil.containsOnlyOpponenet(playerPositions, opposingPositions)){
			score += 5
		}
		if(positionUtil.hasMoreEvens(opposingPositions) && positionUtil.isOdd(trialPosition)){
			score += 5
		}else if(positionUtil.hasMoreOdds(opposingPositions) && positionUtil.isEven(trialPosition)){
			score += 5
		}
		
		if(opposingPositions.size() == 2){
			score = 100000
		}
		if(positionUtil.containsBoth(playerPositions, opposingPositions)){
			score = 0
		}
		
		if(!positionUtil.containsIndex(openPositions, trialPosition)){
			score = 0
		}
		score
	}
}