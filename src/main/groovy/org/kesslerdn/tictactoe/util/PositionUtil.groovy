package org.kesslerdn.tictactoe.util

import java.util.List;

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class PositionUtil {
	
	Boolean areOppositeCornersMarked(List<Position> positions, Mark mark){
		List<Position> matching = findMark(positions, mark)
		List<Integer> locations = matching.collect{it.index}
		(locations.contains(1) && locations.contains(9)) || (locations.contains(3) && locations.contains(7))
	}
	
	Boolean isEven(Position position){
		position.index % 2 == 0
	}
	
	Boolean isOdd(Position position){
		!isEven(position)
	}
	
	Integer evenCount(List<Position> positions){
		positions.count{isEven(it)}
	}
	
	Integer oddCount(List<Position> positions){
		positions.count{isOdd(it)}
	}
	
	List<Position> findMark(List<Position> positions, Mark mark){
		positions.findAll{it.mark == mark}
	}
	
	Boolean containsOnlyOpponenet(List<Position> playerPositions, List<Position> opposingPositions){
		opposingPositions.size() == 1 && playerPositions.empty
	}
	
	Boolean containsBoth(List<Position> playerPositions, List<Position> opposingPositions){
		playerPositions.size() > 0 && opposingPositions.size() > 0
	}
	
	Boolean hasMoreEvens(List<Position> positions){
		evenCount(positions) > oddCount(positions)
	}
	
	Boolean hasMoreOdds(List<Position> positions){
		oddCount(positions) > evenCount(positions)
	}

	private Boolean containsIndex(List<Position> positions, Position position){
		positions.collect{it.index}.contains(position.index)
	}
	
	
	private isFirstTurnWithCenterPositionOpen(List<Position> playerPositions, List<Position> opposingPositions, Position trialPosition){
		containsOnlyOpponenet(playerPositions, opposingPositions) && opposingPositions[0].index != 5 && trialPosition.index == 5
	}
	
	private isFirstTurnWithCenterPositionTaken(List<Position> playerPositions, List<Position> opposingPositions, Position trialPosition){
		containsOnlyOpponenet(playerPositions, opposingPositions) && opposingPositions[0].index == 5 && trialPosition.index == 3
	}

}