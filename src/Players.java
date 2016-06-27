import java.util.List;

public class Players {
    private final List<Player> players;
    private Player currentPlayer;

    public Players(Player currentPlayer, List<Player> players) {
        this.currentPlayer = currentPlayer;
        this.players = players;
    }

    public Player getNextPlayer() {
        int lastPlayerPosition = players.size() - 1;
        int currentPlayerPosition = players.indexOf(currentPlayer);

        if(currentPlayerPosition == lastPlayerPosition) {
            currentPlayerPosition = 0;
        }else{
            currentPlayerPosition++;
        }
        return players.get(currentPlayerPosition);
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }
}
