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
        GameOverConditions gameOverConditions = new GameOverConditions();
        Player playerOne = new Player("X");
        Player playerTwo = new Player("O");
        Players players = new Players(0, playerOne, playerTwo);
        MoveValidator moveValidator = new MoveValidator(boardState);
        Game game = new Game(board, playerInput, gameOverConditions, players, moveValidator, printStream);
        game.start();
    }
}
