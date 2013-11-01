package org.kesslerdn.tictactoe.view;

import static org.junit.Assert.*

import javax.annotation.Resource

import org.kesslerdn.tictactoe.game.player.TestRandomHumanPlayer;
import org.springframework.stereotype.Component


public class TestGameControl implements GameControl {

	static final String TIE = 'This game ended in a tie!'
	static final String PLAYER_O_WON = "Player 'O' won!"
	static final String PLAYER_X_WON = "Player 'X' won!"
	
	List<String> expectedMessages = []
	boolean onlyFinalScore
	private int i
	
	@Override
	public int request(String message) {
		throw new IllegalAccessException()
	}

	@Override
	public void status(String message) {
		String expected = expectedMessages[i]
		if(onlyFinalScore){
			if(message.contains("tie!") || message.contains("won!")){
				if(message == PLAYER_X_WON) println TestRandomHumanPlayer.plays
				assert(message == TIE || message == PLAYER_O_WON)
				TestRandomHumanPlayer.plays = []
			}
		}else{
			assert expected == message
			i++
		}
	}

}