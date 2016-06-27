import java.io.IOException;

public class Game {
    private Board board;
    private GameOverConditions gameOverConditions;
    private Players players;
    private PlayerInputPrompter playerPrompter;

    public Game(Board board, GameOverConditions gameOverConditions, Players players, PlayerInputPrompter playerPrompter) {
        this.board = board;
        this.gameOverConditions = gameOverConditions;
        this.players = players;
        this.playerPrompter = playerPrompter;
    }

    public void start(){
        board.drawBoard();
        try {
            Player currentPlayer = players.getNextPlayer();
            do{
                currentPlayer = playerPrompter.promptNextPlayerForInput(currentPlayer);
            }while(!gameOverConditions.isGameOver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
