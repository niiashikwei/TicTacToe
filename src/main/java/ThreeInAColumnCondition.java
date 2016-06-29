import java.io.PrintStream;
import java.util.List;

public class ThreeInAColumnCondition implements GameOverCondition {
    private final List<String> boardState;
    private final Players players;
    private PrintStream printStream;

    public ThreeInAColumnCondition(List<String> boardState, Players players, PrintStream printStream) {
        this.boardState = boardState;
        this.players = players;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isThreeInAColumn = ifAnyColumnIsFilledWithPlayerSymbol();
        if(isThreeInAColumn) printStream.println(String.format("Player %s Wins!", players.getCurrentPlayer().getSymbol()));
        return isThreeInAColumn;
    }

    private boolean ifAnyColumnIsFilledWithPlayerSymbol() {
        return firstColumnHasOnlyPlayerSymbol() || secondColumnHasOnlyPlayerSymbol() || thirdColumnHasOnlyPlayerSymbol();
    }

    private boolean firstColumnHasOnlyPlayerSymbol() {
        return boardState.get(0).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(3).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(6).equals(players.getCurrentPlayer().getSymbol());
    }

    private boolean secondColumnHasOnlyPlayerSymbol() {
        return boardState.get(1).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(4).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(7).equals(players.getCurrentPlayer().getSymbol());
    }

    private boolean thirdColumnHasOnlyPlayerSymbol() {
        return boardState.get(2).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(5).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(8).equals(players.getCurrentPlayer().getSymbol());
    }
}
