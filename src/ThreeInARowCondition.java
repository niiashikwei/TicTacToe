import java.io.PrintStream;
import java.util.List;

public class ThreeInARowCondition implements GameOverCondition {
    private final List<String> boardState;
    private final Player currentPlayer;
    private PrintStream printStream;

    public ThreeInARowCondition(List<String> boardState, Player player, PrintStream printStream) {
        this.boardState = boardState;
        this.currentPlayer = player;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isThreeInARow = ifAnyRowIsFilledWithPlayerSymbol();
        if(isThreeInARow) printStream.println(String.format("Player %s Wins!", currentPlayer.getSymbol()));
        return isThreeInARow;
    }

    private boolean ifAnyRowIsFilledWithPlayerSymbol() {
        return firstRowHasOnlyPlayerSymbol() || secondRowHasOnlyPlayerSymbol() || thirdRowHasOnlyPlayerSymbol();
    }

    private boolean firstRowHasOnlyPlayerSymbol() {
        return boardState.get(0).equals(currentPlayer.getSymbol()) && boardState.get(1).equals(currentPlayer.getSymbol()) && boardState.get(2).equals(currentPlayer.getSymbol());
    }

    private boolean secondRowHasOnlyPlayerSymbol() {
        return boardState.get(3).equals(currentPlayer.getSymbol()) && boardState.get(4).equals(currentPlayer.getSymbol()) && boardState.get(5).equals(currentPlayer.getSymbol());
    }

    private boolean thirdRowHasOnlyPlayerSymbol() {
        return boardState.get(6).equals(currentPlayer.getSymbol()) && boardState.get(7).equals(currentPlayer.getSymbol()) && boardState.get(8).equals(currentPlayer.getSymbol());
    }
}
