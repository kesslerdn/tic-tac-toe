package org.kesslerdn.tictactoe.ai.strategy.exhaustive

class PlaySequenceAnalyzer implements SequenceAnalyzer {
	private List<List<Integer>> winningSequences = []
	IntegerSequence integerSequence
	
	PlaySequenceAnalyzer(IntegerSequence integerSequence){
		this.integerSequence = integerSequence
		
		[[1,2,3], [4,5,6], [7,8,9],
		 [1,4,7], [2,5,8], [3,6,9],
		 [1,5,9], [3,5,7]].each{ sequence ->
		 	winningSequences << sequence.asImmutable()
			winningSequences << sequence.reverse().asImmutable()
		}
	}
	
	@Override
	public Boolean oddWins() {
		return false;
	}
	@Override
	public Boolean evenWins() {
		List<Integer> order = []
		integerSequence.even.indexOf(order)
		return false;
	}
	@Override
	public Boolean isTie() {
		return false;
	}
	@Override
	public Integer oddWinsIn() {
		return 0;
	}
	@Override
	public Integer evenWinsIn() {
		return 0;
	}

}
