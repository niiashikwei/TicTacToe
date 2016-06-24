import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private Board board;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream, newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9"));
    }

    @Test
    public void shouldDrawAThreeByThreeNumberedBoard(){
        board.drawBoard();

        verify(printStream).println("1|2|3\n-----\n4|5|6\n-----\n7|8|9\n");
    }

    @Test
    public void shouldUpdateTheBoardWithAPlayerSymbolAtASpecifiedPosition(){
        Board expectedBoard = new Board(printStream, newArrayList("1", "2", "X", "4", "5", "6", "7", "8", "9"));

        board.updateBoard(3, "X");

        assertThat(board, is(expectedBoard));
    }


}
