import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;


public class GameTest {

    private Game game;
    private GameOverConditions gameOverConditions;
    private PlayerInputPrompter playerPrompter;
    private Board board;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        gameOverConditions = mock(GameOverConditions.class);
        when(gameOverConditions.isGameOver()).thenReturn(true);
        playerPrompter = mock(PlayerInputPrompter.class);
        game = new Game(board, gameOverConditions, playerPrompter);
    }

    @Test
    public void shouldDrawBoardAtTheBeginningOfTheGame(){
        game.start();

        verify(board, times(1)).drawBoard();
    }

    @Test
    public void shouldCheckIfTheGameIsOverAfterAPlayerMakesAMove() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(true);

        game.start();

        verify(gameOverConditions, times(1)).isGameOver();
    }

    @Test
    public void shouldKeepPromptingForInputWhileGameNotOver() throws IOException {
        when(gameOverConditions.isGameOver()).thenReturn(true);

        game.start();

        verify(playerPrompter, times(1)).promptNextPlayerForInput();
        verify(playerPrompter, times(1)).promptNextPlayerForInput();
    }

}
