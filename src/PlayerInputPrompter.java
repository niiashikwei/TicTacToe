import java.io.IOException;
import java.io.PrintStream;

public class PlayerInputPrompter {
    private PlayerInput playerInput;
    private MoveValidator moveValidator;
    private PrintStream printStream;
    private Board board;
    private Players players;

    public PlayerInputPrompter(PlayerInput playerInput, MoveValidator moveValidator, PrintStream printStream, Board board, Players players) {
        this.playerInput = playerInput;
        this.moveValidator = moveValidator;
        this.printStream = printStream;
        this.board = board;
        this.players = players;
    }

    public Player promptNextPlayerForInput(Player currentPlayer) throws IOException {
        String input = playerInput.getInput();
        if(moveValidator.isValidMove(input)) {
            board.updateBoard(Integer.parseInt(input), currentPlayer.getSymbol());
            currentPlayer = players.getNextPlayer();
        }else{
            printStream.println("Location already taken! Please try again.\n");
        }
        board.drawBoard();
        return currentPlayer;
    }
}
