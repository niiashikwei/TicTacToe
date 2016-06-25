import java.io.IOException;

public class Game {
    private Board board;
    private PlayerInput playerInput;
    private GameOverConditions gameOverConditions;
    private Players players;

    public Game(Board board, PlayerInput playerInput, GameOverConditions gameOverConditions, Players players) {
        this.board = board;
        this.playerInput = playerInput;
        this.gameOverConditions = gameOverConditions;
        this.players = players;
    }

    public void start(){
        board.drawBoard();
        try {
            do{
                String input = playerInput.getInput();
                Player currentPlayer = players.getNextPlayer();
                board.updateBoard(Integer.parseInt(input), currentPlayer.getSymbol());
                board.drawBoard();
            }while(!gameOverConditions.isGameOver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
