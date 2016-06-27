import java.io.IOException;

public class Game {
    private Board board;
    private GameOverConditions gameOverConditions;
    private PlayerInputPrompter playerPrompter;

    public Game(Board board, GameOverConditions gameOverConditions, PlayerInputPrompter playerPrompter) {
        this.board = board;
        this.gameOverConditions = gameOverConditions;
        this.playerPrompter = playerPrompter;
    }

    public void start(){
        board.drawBoard();
        try {
            do{
                playerPrompter.promptNextPlayerForInput();
            }while(!gameOverConditions.isGameOver());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
