package org.kesslerdn.tictactoe.ai.strategy.exhaustive

import java.util.List

class TicTacToePlayPermutationFactory implements PermutationFactory {

	@Override
	public List<IntegerSequence> create() {
		List<List<Integer>> permutations = []
		[1,2,3,4,5,6,7,8,9].eachPermutation{
			permutations << it
		}

		List<IntegerSequence> playSequencePermutations = []
			permutations.each{ permutation ->
				List<Integer> oddSequence = []
				List<Integer> evenSequence = []
				permutation.eachWithIndex{position, i -> 
						if(i % 2 == 0){
							evenSequence << position
						} else {
							oddSequence << position
						}
					}

				playSequencePermutations << new PlaySequence(sequence:permutation, 
					odd:oddSequence, even: evenSequence)
			}
		playSequencePermutations
	}
}
