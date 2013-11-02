## TicTacToe
This is an unbeatable AI built incrementally through TDD.

## Building from source
TicTacToe uses a [Gradle](http://www.gradle.org/)-based build system. The only
prerequisites are [Git](https://github.com/) and JDK 1.7+.

### check out sources
`https://github.com/kesslerdn/tic-tac-toe.git`

### compile and test, build all jars, distribution zip
`./gradle build distZip`

### run TicTacToe
1. explode zip in `/build/distributions/`
2. run script at the root of the exploded directory `./bin/tic-tac-toe`

## run acceptance test
`/tic-tac-toe/src/test/groovy/org/kesslerdn/tictactoe/acceptance/SpringRandomVsComputerTest.groovy`
<pre lang="groovy">
	@Test
	void testStart() {
		(1..10).each{
      ...
</pre>

To run more random plays against the ai simply increase `10` to a 
larger number. A value of `1000` takes about 1 minute and 20 seconds to execute.  This is due, in part, 
to the Spring Framework load time required to create each new game.

## License
This library is free software; you can redistribute it and/or
modify it under the terms of the GNU Lesser General Public
License as published by the Free Software Foundation version 3.0.

This library is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
Lesser General Public License for more details.

You should have received a copy of the GNU Lesser General Public
License along with this library; if not, please visit 
http://www.gnu.org/licenses/lgpl-3.0.txt.
