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
		
		if(positionUtil.isFirstTurnWithCenterPositionOpen(playerPositions, opposingPositions, trialPosition)){
			score = 100000
		}else if (positionUtil.isFirstTurnWithCenterPositionTaken(playerPositions, opposingPositions, trialPosition)){
			score = 100000
		}else{
			score = 1 * weightMap[playerPositions.size()]
			score = favorOpponentSelectedRows(score, playerPositions, opposingPositions)
			score = favorOppositeBoardStrategy(score, playerPositions, opposingPositions, trialPosition);
			score = favorOpponentDominatedRows(score, playerPositions, opposingPositions)
			score = ignoreBlockedRows(score, playerPositions, opposingPositions)
			score = ignoreUnavailableTrialPeriods(score, openPositions, trialPosition)
		}
		score
	}

	private Integer ignoreUnavailableTrialPeriods(Integer score, List<Position> openPositions, Position trialPosition){
		if(!positionUtil.containsIndex(openPositions, trialPosition)){
			score = 0
		}
		score
	}
	
	private Integer ignoreBlockedRows(Integer score, List<Position> playerPositions, List<Position> opposingPositions){
		if(positionUtil.containsBoth(playerPositions, opposingPositions)){
			score = 0
		}
		score
	}
	
	private Integer favorOpponentDominatedRows(Integer score, List<Position> playerPositions, List<Position> opposingPositions){
		if(opposingPositions.size() == 2){
			score = 100000
		}
		score
	}
		
	private Integer favorOpponentSelectedRows(Integer score, List<Position> playerPositions, List<Position> opposingPositions){
		if(positionUtil.containsOnlyOpponenet(playerPositions, opposingPositions)){
			score += 5
		}
		score
	}
		
	private Integer favorOppositeBoardStrategy(Integer score, List<Position> playerPositions, List<Position> opposingPositions, Position trialPosition){
		if(positionUtil.hasMoreEvens(opposingPositions) && positionUtil.isOdd(trialPosition)){
			score += 5
		}else if(positionUtil.hasMoreOdds(opposingPositions) && positionUtil.isEven(trialPosition)){
			score += 5
		}
		score
	}
}