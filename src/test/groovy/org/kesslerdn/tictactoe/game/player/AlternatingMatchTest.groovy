package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Score
import org.kesslerdn.tictactoe.game.Tracker

class AlternatingMatchTest extends GroovyTestCase{

	private Tracker tracker
	private Board board
	private Player player
	private Turn players
	private Score score
	private Match match
	private int playCount = 0
	private int displayCount = 0
	
	@Before
	void setUp(){
		board = [:] as Board
		players = [next: {player}] as Turn
		player = [play:{a ->
			assertSame(board, a)
			playCount++
			}
		] as Player
	
		score = [display:{a ->
			assertSame(board, a)
			displayCount++
			}
		] as Score
	}
	
	@Test
	void testStart() {
		tracker = [isActive:{a -> true}] as Tracker
		match = new AlternatingMatch(tracker:tracker, board:board, players:players, score:score)
		
		match.start()
		
		assert 9 == playCount
		assert 1 == displayCount
	}
	
	@Test
	void testStart_NotActive() {	
		tracker = [isActive:{a -> false}] as Tracker
		match = new AlternatingMatch(tracker:tracker, board:board, players:players, score:score)
		
		match.start()
		
		assert 0 == playCount
		assert 1 == displayCount
	}
}
