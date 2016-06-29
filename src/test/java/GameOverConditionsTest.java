import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class GameOverConditionsTest {

    private GameOverCondition condition;
    private GameOverConditions gameOverConditions;

    @Before
    public void setUp(){
        condition = mock(GameIsADrawCondition.class);
        gameOverConditions = new GameOverConditions(condition);
    }

    @Test
    public void shouldReturnTrueIfAnyConditionsEvaluateToTrue(){
        when(condition.evaluate()).thenReturn(true);

        boolean isGameOver = gameOverConditions.isGameOver();

        assertThat(isGameOver, is(true));
    }

    @Test
    public void shouldReturnFalseIfNoConditionsEvaluateToTrue(){
        when(condition.evaluate()).thenReturn(false);

        boolean isGameOver = gameOverConditions.isGameOver();

        assertThat(isGameOver, is(false));
    }

}