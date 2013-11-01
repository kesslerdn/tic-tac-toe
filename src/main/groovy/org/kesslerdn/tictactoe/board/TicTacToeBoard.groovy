package org.kesslerdn.tictactoe.board

import javax.annotation.Resource

import org.kesslerdn.tictactoe.board.position.Position
import org.kesslerdn.tictactoe.game.player.Mark
import org.springframework.stereotype.Component

@Component
class TicTacToeBoard implements Board{

	@Resource List<Position> positions
	@Resource List<List<Position>> rows
	
	@Override
	String display(){
		String value = ""
		positions.each{value += it.write()}
		value
	}
	
	@Override
	void mark(int positionValue, Mark mark){
		Position position = positions.find{it.index == positionValue}
		position.mark = mark
	}

	@Override
	boolean isOpen(int index) {
		Position position = positions.find{it.index == index}
		if(position){
			position.mark == null
		}else{
			false
		}
	}
}
