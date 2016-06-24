import java.io.IOException;

public class Game {
    private Board board;
    private PlayerInput playerInput;

    public Game(Board board, PlayerInput playerInput) {
        this.board = board;
        this.playerInput = playerInput;
    }

    public void start(){
        board.drawBoard();
        try {
            playerInput.getInput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
