import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GameIsADrawConditionTest {

    private GameOverCondition gameOverCondition;
    private PrintStream printStream;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
    }

    @Test
    public void shouldReturnTrueIfBoardIsFull(){
        List<String> boardState = newArrayList("X", "O", "X", "X", "O", "X", "O", "O", "X");
        gameOverCondition = new GameIsADrawCondition(boardState, printStream);

        boolean result = gameOverCondition.evaluate();

        assertThat(result, is(true));
    }

    @Test
    public void shouldPrintDrawMessageIfNoPositionsLeftToFill(){
        List<String> boardState = newArrayList("X", "O", "X", "X", "O", "X", "O", "O", "X");
        gameOverCondition = new GameIsADrawCondition(boardState, printStream);

        gameOverCondition.evaluate();

        verify(printStream).println("Game is a draw\n");
    }

    @Test
    public void shouldReturnFalseIfBoardIsNotFull(){
        List<String> boardState = newArrayList("X", "O", "X", "4", "O", "X", "7", "X", "O");
        gameOverCondition = new GameIsADrawCondition(boardState, printStream);

        boolean result = gameOverCondition.evaluate();

        assertThat(result, is(false));
    }
}