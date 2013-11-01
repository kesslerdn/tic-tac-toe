package org.kesslerdn.tictactoe.game.player

import static org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import org.kesslerdn.tictactoe.game.Board
import org.kesslerdn.tictactoe.game.Mark
import org.kesslerdn.tictactoe.game.Position
import org.kesslerdn.tictactoe.game.PositionLocator
import org.kesslerdn.tictactoe.view.GameControl

class ComputerPlayerTest extends GroovyTestCase {
	static final Mark MARK = Mark.O
	static final int FIRST_POSITION = 1
	
	@Test
	void testPlay(){
		Board board = [mark:{position,mark ->
			assert FIRST_POSITION == position
			assert MARK == mark
		}] as Board
	
		PositionLocator positionLocator = [locate:{a,b -> FIRST_POSITION}] as PositionLocator
		GameControl gameControl = [status:{message -> assert "Player $MARK played position ${FIRST_POSITION}." == message}] as GameControl
		ComputerPlayer player = new ComputerPlayer(mark:MARK, gameControl:gameControl, positionLocator:positionLocator)
		
		player.play(board)
	}
}
