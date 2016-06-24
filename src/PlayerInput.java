import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class PlayerInput {
    private BufferedReader bufferedReader;
    private PrintStream printStream;

    public PlayerInput(BufferedReader bufferedReader, PrintStream printStream) {
        this.bufferedReader = bufferedReader;
        this.printStream = printStream;
    }

    public int getInput() throws IOException {
        printStream.println("Please enter the number corresponding to the position you want to play: ");
        return bufferedReader.read();
    }
}
