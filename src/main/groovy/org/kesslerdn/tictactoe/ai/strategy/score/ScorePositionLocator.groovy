package org.kesslerdn.tictactoe.ai.strategy.score

import java.util.Map.Entry

import javax.annotation.Resource

import org.kesslerdn.tictactoe.ai.strategy.PositionLocator
import org.kesslerdn.tictactoe.board.Board
import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.kesslerdn.tictactoe.util.MarkUtil;
import org.springframework.stereotype.Component


@Component
class ScorePositionLocator implements PositionLocator {
	
	@Resource private PositionsLocator positionsLoctor
	@Resource private ScoreCalculator scoreCalculator
	@Resource private MarkUtil markUtil
	
	@Override
	public Integer locate(Board board, Mark mark) {
		Map<Integer, Integer> positionScores = [:]
		List<Integer> positions = positionsLoctor.locate(board)
		positions.each{position ->
			Position trialPosition = new TrialPosition(index:position, mark:mark)
			positionScores[trialPosition.index] = calculateBoardScenario(board, trialPosition)
		}
		Entry maxEntry = positionScores.max{it.value}
		return maxEntry.key;
	}

	private Integer calculateBoardScenario(Board board, Position trialPosition){
		int total = 0
		board.rows.each{row ->
			 total += scoreCalculator.calculate(row, trialPosition)
		}
		Mark mark = trialPosition.mark
		Mark opposingMark= markUtil.retrieveOpponentMark(trialPosition.mark)
		List<Position> opposingPositions = board.positions.findAll{it.mark && it.mark == opposingMark}
		if(opposingPositions.size() == 2 && areOppositeCorners(opposingPositions) && isEven(trialPosition)){
			total += 10
		}
		total
	}
	
	private Boolean areOppositeCorners(List<Position> positions){
		List<Integer> locations = positions.collect{it.index}
		(locations.contains(1) && locations.contains(9)) || (locations.contains(3) && locations.contains(7))
	}
		
	private Boolean isEven(Position position){
		position.index % 2 == 0
	}

}
