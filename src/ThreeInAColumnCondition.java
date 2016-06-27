import java.io.PrintStream;
import java.util.List;

public class ThreeInAColumnCondition implements GameOverCondition {
    private final List<String> boardState;
    private final Player currentPlayer;
    private PrintStream printStream;

    public ThreeInAColumnCondition(List<String> boardState, Player player, PrintStream printStream) {
        this.boardState = boardState;
        this.currentPlayer = player;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isThreeInAColumn = ifAnyColumnIsFilledWithPlayerSymbol();
        if(isThreeInAColumn) printStream.println(String.format("Player %s Wins!", currentPlayer.getSymbol()));
        return isThreeInAColumn;
    }

    private boolean ifAnyColumnIsFilledWithPlayerSymbol() {
        return firstColumnHasOnlyPlayerSymbol() || secondColumnHasOnlyPlayerSymbol() || thirdColumnHasOnlyPlayerSymbol();
    }

    private boolean firstColumnHasOnlyPlayerSymbol() {
        return boardState.get(0).equals(currentPlayer.getSymbol()) && boardState.get(3).equals(currentPlayer.getSymbol()) && boardState.get(6).equals(currentPlayer.getSymbol());
    }

    private boolean secondColumnHasOnlyPlayerSymbol() {
        return boardState.get(1).equals(currentPlayer.getSymbol()) && boardState.get(4).equals(currentPlayer.getSymbol()) && boardState.get(7).equals(currentPlayer.getSymbol());
    }

    private boolean thirdColumnHasOnlyPlayerSymbol() {
        return boardState.get(2).equals(currentPlayer.getSymbol()) && boardState.get(5).equals(currentPlayer.getSymbol()) && boardState.get(8).equals(currentPlayer.getSymbol());
    }
}
