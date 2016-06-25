import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PlayersTest {

    public static final int FIRST_PLAYER_POSITION = 0;
    private static final int SECOND_PLAYER_POSITION = 1;
    private Player playerOne;
    private Player playerTwo;
    private Players players;

    @Before
    public void setUp(){
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
    }

    //ToDo: figure out better way to test this
    @Test
    public void shouldCycleThroughPlayers(){
        players = new Players(FIRST_PLAYER_POSITION, playerOne, playerTwo);

        Player nextPlayer;
        nextPlayer = players.getNextPlayer();
        assertThat(nextPlayer, is(playerOne));

        nextPlayer = players.getNextPlayer();
        assertThat(nextPlayer, is(playerTwo));

        nextPlayer = players.getNextPlayer();
        assertThat(nextPlayer, is(playerOne));
    }
}