import java.io.*;
import java.util.ArrayList;

import static com.google.common.collect.Lists.newArrayList;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        ArrayList<String> boardState = newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        Board board = new Board(printStream, boardState);

        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        PlayerInput playerInput = new PlayerInput(new BufferedReader(reader), printStream);

        Player playerOne = new Player("X");
        Player playerTwo = new Player("O");
        Players players = new Players(playerOne, newArrayList(playerOne, playerTwo));

        GameOverCondition threeInARowCondition = new ThreeInARowCondition(boardState, players, printStream);
        GameOverCondition threeInAColumnCondition = new ThreeInAColumnCondition(boardState, players, printStream);
        GameOverCondition threeInADiagonalCondition = new ThreeInADiagonalCondition(boardState, players, printStream);
        GameOverCondition gameIsADrawCondition = new GameIsADrawCondition(boardState, printStream);
        GameOverConditions gameOverConditions = new GameOverConditions(gameIsADrawCondition, threeInARowCondition, threeInAColumnCondition, threeInADiagonalCondition);

        MoveValidator moveValidator = new MoveValidator(boardState);
        PlayerInputPrompter playerPrompter = new PlayerInputPrompter(playerInput, moveValidator, printStream, board, players, playerOne);
        Game game = new Game(board, gameOverConditions, playerPrompter);
        game.start();
    }
}
