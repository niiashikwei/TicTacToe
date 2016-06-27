import org.junit.Before;
import org.junit.Test;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class PlayersTest {

    private Player playerOne;
    private Player playerTwo;
    private Players players;

    @Before
    public void setUp(){
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
    }

    @Test
    public void shouldReturnPlayerTwoIfPlayerOneIsCurrentPlayer(){
        players = new Players(playerOne, newArrayList(playerOne, playerTwo));

        Player nextPlayer = players.getNextPlayer();

        assertThat(nextPlayer, is(playerTwo));
    }

    @Test
    public void shouldReturnPlayerOneIfPlayerTwoIsCurrentPlayer(){
        players = new Players(playerTwo, newArrayList(playerOne, playerTwo));

        Player nextPlayer = players.getNextPlayer();

        assertThat(nextPlayer, is(playerOne));
    }
}