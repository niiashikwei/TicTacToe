import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class PlayerInputTest{

    private BufferedReader bufferedReader;
    private PlayerInput playerInput;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        printStream = mock(PrintStream.class);
        playerInput = new PlayerInput(bufferedReader, printStream);
    }

    @Test
    public void shouldPromptPlayerForInput() throws IOException {

        playerInput.getInput();

        verify(printStream).println("Please enter the number corresponding to the position you want to play: ");
        verify(bufferedReader).read();
    }
}