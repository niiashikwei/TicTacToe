import java.io.PrintStream;
import java.util.List;

public class GameIsADrawCondition implements GameOverCondition{
    private List<String> boardState;
    private PrintStream printStream;

    public GameIsADrawCondition(List<String> boardState, PrintStream printStream) {
        this.boardState = boardState;
        this.printStream = printStream;
    }

    @Override
    public boolean evaluate() {
        boolean isGameOver = true;
        for(int i = 0; i < boardState.size(); i++){
            String position = boardState.get(i);
            try{
                Integer.parseInt(position);
                isGameOver = false;
                break;
            }catch(NumberFormatException e){}
        }
        if (isGameOver){
            printStream.println("Game is a draw\n");
        }
        return isGameOver;
    }
}
