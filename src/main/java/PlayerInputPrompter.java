import java.io.IOException;
import java.io.PrintStream;

public class PlayerInputPrompter {
    private PlayerInput playerInput;
    private MoveValidator moveValidator;
    private PrintStream printStream;
    private Board board;
    private Players players;
    private Player currentPlayer;

    public PlayerInputPrompter(PlayerInput playerInput, MoveValidator moveValidator, PrintStream printStream, Board board, Players players, Player currentPlayer) {
        this.playerInput = playerInput;
        this.moveValidator = moveValidator;
        this.printStream = printStream;
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public void promptNextPlayerForInput() throws IOException {
        String input = playerInput.getInput();
        if(moveValidator.isValidMove(input)) {
            board.updateBoard(Integer.parseInt(input), currentPlayer.getSymbol());
            currentPlayer = players.getNextPlayer();
        }else{
            printStream.println("Location already taken! Please try again.\n");
        }
        board.drawBoard();
    }
}
