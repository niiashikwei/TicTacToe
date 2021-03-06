import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ThreeInARowConditionTest {

    private PrintStream printStream;
    private Player currentPlayer;
    private Players players;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        currentPlayer = mock(Player.class);
        players = mock(Players.class);
        when(players.getCurrentPlayer()).thenReturn(currentPlayer);
    }

    @Test
    public void shouldReturnTrueIfAPlayerHasThreeInARow(){
        List<String> boardState = newArrayList("X", "X", "X", "4", "O", "6", "O", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInARowCondition(boardState, players, printStream);

        boolean isThreeInARow = condition.evaluate();

        assertThat(isThreeInARow, is(true));
    }

    @Test
    public void shouldReturnFalseIfAPlayerDoesntHaveThreeInARow(){
        List<String> boardState = newArrayList("X", "X", "X", "4", "O", "6", "O", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("O");

        GameOverCondition condition = new ThreeInARowCondition(boardState, players, printStream);

        boolean isThreeInARow = condition.evaluate();

        assertThat(isThreeInARow, is(false));
    }

    @Test
    public void shouldPrintMessageInformingWinnerOfWin(){
        List<String> boardState = newArrayList("X", "X", "X", "4", "O", "6", "O", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInARowCondition(boardState, players, printStream);

        condition.evaluate();

        verify(printStream).println("Player X Wins!");
    }

}
