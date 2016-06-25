import java.io.IOException;
import java.io.PrintStream;

public class Game {
    private Board board;
    private PlayerInput playerInput;
    private GameOverConditions gameOverConditions;
    private Players players;
    private MoveValidator moveValidator;
    private PrintStream printStream;

    public Game(Board board, PlayerInput playerInput, GameOverConditions gameOverConditions, Players players, MoveValidator moveValidator, PrintStream printStream) {
        this.board = board;
        this.playerInput = playerInput;
        this.gameOverConditions = gameOverConditions;
        this.players = players;
        this.moveValidator = moveValidator;
        this.printStream = printStream;
    }

    public void start(){
        board.drawBoard();
        try {
            Player currentPlayer = players.getNextPlayer();
            do{
                String input = playerInput.getInput();
                if(moveValidator.isValidMove(input)) {
                    board.updateBoard(Integer.parseInt(input), currentPlayer.getSymbol());
                    currentPlayer = players.getNextPlayer();
                }else{
                    printStream.println("Location already taken! Please try again.\n");
                }
                board.drawBoard();
            }while(!gameOverConditions.isGameOver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
