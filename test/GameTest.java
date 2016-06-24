import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {

    private Game game;
    private Board board;
    private PlayerInput playerInput;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        playerInput = mock(PlayerInput.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, playerInput);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();

        verify(board).drawBoard();
    }

    @Test
    public void shouldPromptTheFirstPlayerForAMoveAfterDrawingTheBoard() throws IOException {
        game.start();

        verify(playerInput).getInput();
    }


}
