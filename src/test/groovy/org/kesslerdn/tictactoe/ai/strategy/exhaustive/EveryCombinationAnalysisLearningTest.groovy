package org.kesslerdn.tictactoe.ai.strategy.exhaustive;

import org.junit.Test
import org.kesslerdn.tictactoe.game.player.Mark

class EveryCombinationAnalysisLearningTest {
	static final List<WinningPattern> winningPatterns = [new WinningPattern(sequence:[1,2,3]), new WinningPattern(sequence:[4,5,6]),
		new WinningPattern(sequence:[7,8,9]), new WinningPattern(sequence:[1,4,7]),
		new WinningPattern(sequence:[2,5,8]), new WinningPattern(sequence:[3,6,9]),
		new WinningPattern(sequence:[1,5,9]), new WinningPattern(sequence:[3,5,7])]
	
	@Test
	void testExperiment(){
		[1,2,3,4,5,6,7,8,9].eachPermutation{ permutation ->
			calculateWinner(permutation)
		}	
		
	}
	void calculateWinner(List<Integer> plays){
			List<Play> board = []
			plays.eachWithIndex{ play, i ->
				board << new Play(order: i, position: play, mark: Mark.values()[i%2], board: board)
			}
			board.sort{it.position}
			Map<Mark, List<Play>> playMap = board.groupBy{it.mark}
			List<Play> winningPlays = []
			winningPatterns.each{pattern ->
				findWinner(winningPlays, playMap, pattern, Mark.X)
				findWinner(winningPlays, playMap, pattern, Mark.O)
			}
	}
	void findWinner(List<Play> winningPlays, Map<Mark, List<Play>> playMap, WinningPattern pattern, Mark mark){
		if(playMap[mark].toString() ==~ pattern.toString()){
			List<Play> matchingPlays = playMap[mark].findAll{play ->
					pattern.sequence[0] == play.position || pattern.sequence[1] == play.position || pattern.sequence[2] == play.position
				}
			winningPlays <<  matchingPlays.max{a, b -> a.order.compareTo(b.order)}
		}
	}
}
	
	class Play{
		int order
		int position
		Mark mark
		List<Play> board

		@Override
		public String toString() {
			position
		}	
	}
	class WinningPattern{
		List<Integer> sequence
		
		@Override
		public String toString() {
			String output = ".*"
			sequence.each{output += "$it.*"}
			output
		}
	}

