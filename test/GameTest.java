import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class GameTest {

    public static final String RANDOM_INPUT_TWO = "5";
    private final String RANDOM_INPUT_ONE = "1";
    private final String PLAYER_ONE_SYMBOL = "X";
    private final String PLAYER_TWO_SYMBOL = "O";
    private Game game;
    private Board board;
    private PlayerInput playerInput;
    private GameOverConditions gameOverConditions;
    private Player firstPlayer;
    private Player secondPlayer;
    private Players players;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerInput = mock(PlayerInput.class);
        gameOverConditions = mock(GameOverConditions.class);
        when(gameOverConditions.isGameOver()).thenReturn(true);
        firstPlayer = mock(Player.class);
        when(firstPlayer.getSymbol()).thenReturn(PLAYER_ONE_SYMBOL);
        secondPlayer = mock(Player.class);
        when(secondPlayer.getSymbol()).thenReturn(PLAYER_TWO_SYMBOL);
        players = mock(Players.class);
        when(players.getNextPlayer()).thenReturn(firstPlayer, secondPlayer);
        game = new Game(board, playerInput, gameOverConditions, players);
    }

    @Test
    public void shouldPromptTheFirstPlayerForAMoveAfterDrawingTheBoard() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);

        game.start();

        verify(playerInput).getInput();
    }

    @Test
    public void shouldUpdateTheBoardWithPlayerOneInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);

        game.start();

        verify(board).updateBoard(Integer.parseInt(RANDOM_INPUT_ONE), PLAYER_ONE_SYMBOL);
    }

    @Test
    public void shouldRedrawTheBoardAfterUpdatingItWithPlayerInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);

        game.start();

        verify(board, times(2)).drawBoard();
    }


    @Test
    public void shouldCheckIfTheGameIsOverAfterAPlayerMakesAMove() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(false, true);
        when(playerInput.getInput()).thenReturn("2");

        game.start();

        verify(gameOverConditions, times(2)).isGameOver();
    }

    @Test
    public void shouldKeepPromptingForInputWhileGameNotOver() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(false, false, true);
        when(playerInput.getInput()).thenReturn("2", "5");

        game.start();

        verify(playerInput, times(3)).getInput();
    }

    @Test
    public void shouldUpdateTheBoardWithPlayerTwoInput() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(false, true);
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE, "5");

        game.start();

        verify(board, times(1)).updateBoard(Integer.parseInt(RANDOM_INPUT_ONE), PLAYER_ONE_SYMBOL);
        verify(board, times(1)).updateBoard(Integer.parseInt(RANDOM_INPUT_TWO), PLAYER_TWO_SYMBOL);
    }
}
