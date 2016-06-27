import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ThreeInAColumnConditionTest {

    private PrintStream printStream;
    private Player currentPlayer;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        currentPlayer = mock(Player.class);
    }

    @Test
    public void shouldReturnTrueIfAPlayerHasThreeInAColumn(){
        List<String> boardState = newArrayList("X", "O", "O", "X", "O", "6", "X", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInAColumnCondition(boardState, currentPlayer, printStream);

        boolean isThreeInAColumn = condition.evaluate();

        assertThat(isThreeInAColumn, is(true));
    }

    @Test
    public void shouldReturnFalseIfAPlayerDoesntHaveThreeInAColumn(){
        List<String> boardState = newArrayList("X", "X", "X", "4", "O", "6", "O", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("O");

        GameOverCondition condition = new ThreeInAColumnCondition(boardState, currentPlayer, printStream);

        boolean isThreeInAColumn = condition.evaluate();

        assertThat(isThreeInAColumn, is(false));
    }

    @Test
    public void shouldPrintMessageInformingWinnerOfWin(){
        List<String> boardState = newArrayList("X", "O", "O", "X", "O", "6", "X", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInAColumnCondition(boardState, currentPlayer, printStream);

        condition.evaluate();

        verify(printStream).println("Player X Wins!");
    }

}
