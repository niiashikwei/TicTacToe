import java.io.PrintStream;
import java.util.List;

public class ThreeInARowCondition implements GameOverCondition {
    private final List<String> boardState;
    private final Players players;
    private PrintStream printStream;

    public ThreeInARowCondition(List<String> boardState, Players players, PrintStream printStream) {
        this.boardState = boardState;
        this.players = players;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isThreeInARow = ifAnyRowIsFilledWithPlayerSymbol();
        if(isThreeInARow) printStream.println(String.format("Player %s Wins!", players.getCurrentPlayer().getSymbol()));
        return isThreeInARow;
    }

    private boolean ifAnyRowIsFilledWithPlayerSymbol() {
        return firstRowHasOnlyPlayerSymbol() || secondRowHasOnlyPlayerSymbol() || thirdRowHasOnlyPlayerSymbol();
    }

    private boolean firstRowHasOnlyPlayerSymbol() {
        return boardState.get(0).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(1).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(2).equals(players.getCurrentPlayer().getSymbol());
    }

    private boolean secondRowHasOnlyPlayerSymbol() {
        return boardState.get(3).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(4).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(5).equals(players.getCurrentPlayer().getSymbol());
    }

    private boolean thirdRowHasOnlyPlayerSymbol() {
        return boardState.get(6).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(7).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(8).equals(players.getCurrentPlayer().getSymbol());
    }
}
