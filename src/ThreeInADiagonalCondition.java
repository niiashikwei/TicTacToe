import java.io.PrintStream;
import java.util.List;

public class ThreeInADiagonalCondition implements GameOverCondition {
    private final List<String> boardState;
    private final Players players;
    private PrintStream printStream;

    public ThreeInADiagonalCondition(List<String> boardState, Players players, PrintStream printStream) {
        this.boardState = boardState;
        this.players = players;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isThreeInADiagonal = ifAnyDiagonalIsFilledWithPlayerSymbol();
        if(isThreeInADiagonal) printStream.println(String.format("Player %s Wins!", players.getCurrentPlayer().getSymbol()));
        return isThreeInADiagonal;
    }

    private boolean ifAnyDiagonalIsFilledWithPlayerSymbol() {
        return firstDiagonalHasOnlyPlayerSymbol() || secondDiagonalHasOnlyPlayerSymbol();
    }

    private boolean firstDiagonalHasOnlyPlayerSymbol() {
        return boardState.get(0).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(4).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(8).equals(players.getCurrentPlayer().getSymbol());
    }

    private boolean secondDiagonalHasOnlyPlayerSymbol() {
        return boardState.get(2).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(4).equals(players.getCurrentPlayer().getSymbol()) && boardState.get(6).equals(players.getCurrentPlayer().getSymbol());
    }

}
