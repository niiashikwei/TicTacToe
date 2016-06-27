import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class GameTest {

    private final String PLAYER_ONE_SYMBOL = "X";
    private final String PLAYER_TWO_SYMBOL = "O";
    private Game game;
    private GameOverConditions gameOverConditions;
    private Players players;
    private Player firstPlayer;
    private Player secondPlayer;
    private PlayerInputPrompter playerPrompter;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        gameOverConditions = mock(GameOverConditions.class);
        when(gameOverConditions.isGameOver()).thenReturn(true);
        firstPlayer = mock(Player.class);
        when(firstPlayer.getSymbol()).thenReturn(PLAYER_ONE_SYMBOL);
        secondPlayer = mock(Player.class);
        when(secondPlayer.getSymbol()).thenReturn(PLAYER_TWO_SYMBOL);
        players = mock(Players.class);
        when(players.getNextPlayer()).thenReturn(firstPlayer, secondPlayer);
        playerPrompter = mock(PlayerInputPrompter.class);
        game = new Game(board, gameOverConditions, players, playerPrompter);
    }


    @Test
    public void shouldCheckIfTheGameIsOverAfterAPlayerMakesAMove() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(true);
        when(players.getNextPlayer()).thenReturn(firstPlayer);

        game.start();

        verify(gameOverConditions, times(1)).isGameOver();
    }

    @Test
    public void shouldKeepPromptingForInputWhileGameNotOver() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(false, true);
        when(players.getNextPlayer()).thenReturn(firstPlayer);
        when(playerPrompter.promptNextPlayerForInput(firstPlayer)).thenReturn(secondPlayer);

        game.start();

        verify(playerPrompter, times(1)).promptNextPlayerForInput(firstPlayer);
        verify(playerPrompter, times(1)).promptNextPlayerForInput(secondPlayer);
    }

}
