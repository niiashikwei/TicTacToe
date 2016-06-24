import java.io.PrintStream;

public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void drawBoard() {
        printStream.println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }
}
