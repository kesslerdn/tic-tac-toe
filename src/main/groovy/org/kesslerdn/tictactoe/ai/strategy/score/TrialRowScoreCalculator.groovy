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
	@Resource private TrialRowFactory trialRowFactory
	
	@Override
	public int calculate(List<Position> positions, Position trialPosition) {
		
		TrialRow trialRow = trialRowFactory.create(positions, trialPosition)
		
		int score = 0
		
		if(positionUtil.isFirstTurnWithCenterPositionOpen(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions(), trialRow.trialPosition)){
			score = 100000
		}else if (positionUtil.isFirstTurnWithCenterPositionTaken(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions(), trialRow.trialPosition)){
			score = 100000
		}else{
			score = 1 * weightMap[trialRow.extractPlayerPositions().size()]
			score = favorOpponentSelectedRows(score, trialRow)
			score = favorOppositeBoardStrategy(score, trialRow);
			score = favorOpponentDominatedRows(score, trialRow)
			score = ignoreBlockedRows(score, trialRow)
			score = ignoreUnavailableTrialPeriods(score, trialRow)
		}
		score
	}

	private int ignoreUnavailableTrialPeriods(int score, TrialRow trialRow){
		if(!positionUtil.containsIndex(trialRow.extractOpenPositions(), trialRow.trialPosition)){
			score = 0
		}
		score
	}
	
	private int ignoreBlockedRows(int score, TrialRow trialRow){
		if(positionUtil.containsBoth(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions())){
			score = 0
		}
		score
	}
	
	private int favorOpponentDominatedRows(int score, TrialRow trialRow){
		if(trialRow.extractOpposingPositions().size() == 2){
			score = 100000
		}
		score
	}
		
	private int favorOpponentSelectedRows(int score, TrialRow trialRow){
		if(positionUtil.containsOnlyOpponenet(trialRow.extractPlayerPositions(), trialRow.extractOpposingPositions())){
			score += 5
		}
		score
	}
		
	private int favorOppositeBoardStrategy(int score, TrialRow trialRow){
		if(positionUtil.hasMoreEvens(trialRow.extractOpposingPositions()) && positionUtil.isOdd(trialRow.trialPosition)){
			score += 5
		}else if(positionUtil.hasMoreOdds(trialRow.extractOpposingPositions()) && positionUtil.isEven(trialRow.trialPosition)){
			score += 5
		}
		score
	}
}