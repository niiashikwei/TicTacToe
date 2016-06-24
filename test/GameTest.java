import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;


public class GameTest {

    private Game game;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        game = new Game(board);
    }

    @Test
    public void shouldPrintBoardWhenGameStarts(){
        game.start();

        verify(board).drawBoard();
    }



}
