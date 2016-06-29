import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private final PrintStream printStream;
    private ArrayList<String> boardState;

    public Board(PrintStream printStream, ArrayList<String> boardState) {
        this.printStream = printStream;
        this.boardState = boardState;
    }

    public void drawBoard() {
        StringBuilder boardRepresentation = new StringBuilder();
        int newRowCounter = 0;
        List<String> allBoardPositionsExceptLastOne = boardState.subList(0, boardState.size()-1);
        for(String position : allBoardPositionsExceptLastOne){
            boardRepresentation.append(position);
            if(newRowCounter != 2){
                boardRepresentation.append("|");
                newRowCounter++;
            }else {
                boardRepresentation.append("\n-----\n");
                newRowCounter = 0;
            }
        }

        boardRepresentation.append(boardState.get(boardState.size()-1)).append("\n");
        printStream.println(boardRepresentation.toString());
    }

    public void updateBoard(int position, String playerSymbol) {
        boardState.set(position -1, playerSymbol);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Board board = (Board) o;

        return boardState.equals(board.boardState);

    }

    @Override
    public int hashCode() {
        return boardState.hashCode();
    }

    @Override
    public String toString() {
        return "Board{" +
                "boardState=" + boardState +
                '}';
    }
}
