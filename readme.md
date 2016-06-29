Tic Tac Toe

Setup
Building : ./gradlew build
IntelliJ : ./gradlew cleanIdea idea

Running Tests
Command line: ./gradlew test


Running Application
The entry point into the application is the 'Main' class. 
It does not require any parameters.

Command line: ./gradlew jar

IntelliJ: run Main.class

Discovered Bugs:
1. When there's a winner, next player still gets prompted for input before the winner is announced and game ends.
2. When application is run from command line it loops endlessly as if player is constantly inputting the same value
