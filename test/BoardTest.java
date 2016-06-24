import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldDrawAThreeByThreeNumberedBoard(){
        board.drawBoard();

        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9");
    }


}
