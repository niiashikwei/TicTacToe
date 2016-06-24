import java.io.*;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        Board board = new Board(printStream);
        InputStream inputStream = System.in;
        Reader reader = new InputStreamReader(inputStream);
        PlayerInput playerInput = new PlayerInput(new BufferedReader(reader), printStream);
        Game game = new Game(board, playerInput);
        game.start();
    }
}
