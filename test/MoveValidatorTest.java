import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class MoveValidatorTest {
    private MoveValidator moveValidator;
    private List boardState;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void shouldReturnTrueIfPositionNotOccupied(){
        boardState = newArrayList("1", "2", "3", "4", "5", "6", "7", "8", "9");
        moveValidator = new MoveValidator(boardState);

        boolean isValidMove = moveValidator.isValidMove("1");

        assertThat(isValidMove, is(true));
    }

    @Test
    public void shouldReturnFalseIfPositionNotOccupied(){
        boardState = newArrayList("X", "2", "3", "4", "5", "6", "7", "8", "9");
        moveValidator = new MoveValidator(boardState);

        boolean isValidMove = moveValidator.isValidMove("1");

        assertThat(isValidMove, is(false));
    }
}