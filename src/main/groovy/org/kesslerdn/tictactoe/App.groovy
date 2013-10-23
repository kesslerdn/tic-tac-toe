package org.kesslerdn.tictactoe

import org.kesslerdn.tictactoe.game.Match
import org.springframework.context.support.ClassPathXmlApplicationContext

class App {

	static main(args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml")
		Match match = context.getBean(Match.class)
		match.start();
	}

}
