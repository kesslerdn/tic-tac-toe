package org.kesslerdn.tictactoe.ai.strategy.score

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class TrialRowScoreCalculator implements ScoreCalculator{
	
	private static final weightMap = [(-3):-100, (-2): -10, (-1): -1, 0:0, 1:10, 2:100, 3:1000]
	@Override
	public Integer calculate(List<Position> positions, Position trialPosition) {
		Mark mark
		Mark opposingMark
		if(Mark.X == trialPosition.mark){
			mark = Mark.X
			opposingMark = Mark.O
		}else{
			mark = Mark.O
			opposingMark = Mark.X
		}
		List<Position> withTrial = positions
		Integer score = 0
		List<Position> openPositions = withTrial.findAll{it.mark == null}
		List<Position> opposingPositions = withTrial.findAll{it.mark && it.mark == opposingMark}
		List<Position> playerPositions = withTrial.findAll{it.mark && it.mark == mark}
		Integer playerNet = playerPositions.size()// - opposingPositions.size()
		score = 1 * weightMap[playerNet]
		if(opposingPositions.size() == 1 && playerPositions.empty){
			score += 5
		}
		if(evenCount(opposingPositions) > oddCount(opposingPositions)){
			if(isOdd(trialPosition)){
				score += 1
			}
		}else if(oddCount(opposingPositions) > evenCount(opposingPositions)){
			if(isEven(trialPosition)){
				score += 1
			}
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
	
	private Integer evenCount(List<Position> positions){
		positions.count{isEven(it)}
	}
	
	private Integer oddCount(List<Position> positions){
		positions.count{isOdd(it)}
	}

	private Boolean isEven(Position position){
		position.index % 2 == 0
	}
	
	
	private Boolean isOdd(Position position){
		position.index % 2 != 0
	}

}
