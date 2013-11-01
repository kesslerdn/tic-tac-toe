TicTacToe
=========

## Building from source
TicTacToe uses a [Gradle][]-based build system. In the instructions
below, [`./gradlew`][] is invoked from the root of the source tree and serves as
a cross-platform, self-contained bootstrap mechanism for the build.

## Building from source
TicTacToe uses a [Gradle][]-based build system. The only
prerequisites are [Git][] and JDK 1.7+.

### check out sources
`https://github.com/kesslerdn/tic-tac-toe.git`

### compile and test, build all jars, distribution zip
`./gradle build distZip`

### run TicTacToe
`./build/distributions/tic-tac-toe-1.0/bin/tic-tac-toe`

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