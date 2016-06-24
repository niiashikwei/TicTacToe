import java.io.*;

import static com.google.common.collect.Lists.newArrayList;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream, newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        PlayerInput playerInput = new PlayerInput(new BufferedReader(reader), printStream);
        Game game = new Game(board, playerInput);
        game.start();
    }
}
