package org.kesslerdn.tictactoe.ai.strategy.exhaustive

interface SequenceAnalyzer {
	Boolean oddWins()
	Boolean evenWins()
	Boolean isTie()
	Integer oddWinsIn()
	Integer evenWinsIn()
}
