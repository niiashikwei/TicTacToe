import java.util.List;

public class MoveValidator {
    private List boardState;

    public MoveValidator(List boardState) {
        this.boardState = boardState;
    }

    public boolean isValidMove(String playerInput) {
        String displayedPosition = Integer.toString(boardState.indexOf(playerInput) + 1);
        return displayedPosition.equals(playerInput);
    }
}
