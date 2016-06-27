import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class ThreeInADiagonalConditionTest {

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
    public void shouldReturnTrueIfAPlayerHasThreeInADiagonal(){
        List<String> boardState = newArrayList("X", "O", "O", "4", "X", "6", "7", "8", "X");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInADiagonalCondition(boardState, players, printStream);

        boolean isThreeInADiagonal = condition.evaluate();

        assertThat(isThreeInADiagonal, is(true));
    }

    @Test
    public void shouldReturnFalseIfAPlayerDoesntHaveThreeInADiagonal(){
        List<String> boardState = newArrayList("O", "O", "X", "4", "X", "6", "X", "8", "O");
        when(currentPlayer.getSymbol()).thenReturn("O");

        GameOverCondition condition = new ThreeInADiagonalCondition(boardState, players, printStream);

        boolean isThreeInADiagonal = condition.evaluate();

        assertThat(isThreeInADiagonal, is(false));
    }

    @Test
    public void shouldPrintMessageInformingWinnerOfWin(){
        List<String> boardState = newArrayList("X", "O", "O", "4", "X", "6", "7", "8", "X");
        when(currentPlayer.getSymbol()).thenReturn("X");

        GameOverCondition condition = new ThreeInADiagonalCondition(boardState, players, printStream);

        condition.evaluate();

        verify(printStream).println("Player X Wins!");
    }

}
