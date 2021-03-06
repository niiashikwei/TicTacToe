import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.*;

public class PlayerInputPrompterTest {
    private final String RANDOM_INPUT_ONE = "1";
    private final String RANDOM_INPUT_TWO = "5";
    private final String PLAYER_ONE_SYMBOL = "X";
    private PlayerInput playerInput;
    private Board board;
    private PlayerInputPrompter playerInputPrompter;
    private MoveValidator moveValidator;
    private PrintStream printStream;
    private Players players;
    private Player currentPlayer;
    private Player nextPlayer;

    @Before
    public void setUp(){
        board = mock(Board.class);
        playerInput = mock(PlayerInput.class);
        moveValidator = mock(MoveValidator.class);
        printStream = mock(PrintStream.class);
        players = mock(Players.class);
        currentPlayer = mock(Player.class);
        nextPlayer = mock(Player.class);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(true);
        when(moveValidator.isValidMove(RANDOM_INPUT_TWO)).thenReturn(true);
        printStream = mock(PrintStream.class);
        playerInputPrompter = new PlayerInputPrompter(playerInput, moveValidator, printStream, board, players, currentPlayer);

    }

    @Test
    public void shouldUpdateTheBoardWithPlayerOneInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(true);
        when(currentPlayer.getSymbol()).thenReturn(PLAYER_ONE_SYMBOL);

        playerInputPrompter.promptNextPlayerForInput();

        verify(board).updateBoard(Integer.parseInt(RANDOM_INPUT_ONE), PLAYER_ONE_SYMBOL);
    }


    @Test
    public void shouldDrawTheBoardAfterUpdatingItWithPlayerInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);

        playerInputPrompter.promptNextPlayerForInput();

        verify(board, times(1)).drawBoard();
    }

    @Test
    public void shouldPromptTheFirstPlayerForAMoveAfterDrawingTheBoard() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);

        playerInputPrompter.promptNextPlayerForInput();

        verify(playerInput).getInput();
    }

    @Test
    public void shouldPromptUserToTryAgainIfLocationIsAlreadyTaken() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(false);

        playerInputPrompter.promptNextPlayerForInput();

        verify(players, never()).getNextPlayer();
        verify(board, never()).updateBoard(anyInt(), anyString());
        assertThat(currentPlayer, is(currentPlayer));
    }

    @Test
    public void shouldPromptNextUserToPlayIfLocationIsNotTaken() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(true);
        when(players.getNextPlayer()).thenReturn(nextPlayer);

        playerInputPrompter.promptNextPlayerForInput();

        verify(players, times(1)).getNextPlayer();
    }

    @Test
    public void shouldUpdateBoardWithCurrentPlayerSymbolWhenMoveIsValid() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(true);
        when(currentPlayer.getSymbol()).thenReturn(PLAYER_ONE_SYMBOL);

        playerInputPrompter.promptNextPlayerForInput();

        verify(board, times(1)).updateBoard(Integer.parseInt(RANDOM_INPUT_ONE), PLAYER_ONE_SYMBOL);
        verify(currentPlayer, times(1)).getSymbol();
    }

    @Test
    public void shouldInformTheUserOfInvalidMove() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT_ONE);
        when(moveValidator.isValidMove(RANDOM_INPUT_ONE)).thenReturn(false);

        playerInputPrompter.promptNextPlayerForInput();

        verify(printStream).println("Location already taken! Please try again.\n");
    }
}