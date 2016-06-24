import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class GameTest {

    private static final String RANDOM_INPUT = "1";
    private final String PLAYER_ONE_SYMBOL = "X";
    private Game game;
    private Board board;
    private PlayerInput playerInput;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerInput = mock(PlayerInput.class);
        game = new Game(board, playerInput);
    }

    @Test
    public void shouldPromptTheFirstPlayerForAMoveAfterDrawingTheBoard() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT);

        game.start();

        verify(playerInput).getInput();
    }

    @Test
    public void shouldUpdateTheBoardWithPlayerInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT);

        game.start();

        verify(board).updateBoard(Integer.parseInt(RANDOM_INPUT), PLAYER_ONE_SYMBOL);
    }

    @Test
    public void shouldRedrawTheBoardAfterUpdatingItWithPlayerInput() throws IOException {
        when(playerInput.getInput()).thenReturn(RANDOM_INPUT);

        game.start();

        verify(board, times(2)).drawBoard();
    }


}
