public class Players {
    private final Player[] players;
    private int currentPlayerPosition;

    public Players(int startingPlayerPosition, Player... players) {
        this.currentPlayerPosition = startingPlayerPosition;
        this.players = players;
        currentPlayerPosition--;
    }

    public Player getNextPlayer() {
        int lastPlayerPosition = players.length - 1;
        if(currentPlayerPosition == lastPlayerPosition) {
            currentPlayerPosition = 0;
        }else{
            currentPlayerPosition++;
        }
        return players[currentPlayerPosition];
    }
}
