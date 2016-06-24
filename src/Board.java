import java.io.PrintStream;
import java.util.ArrayList;

public class Board {
    private final PrintStream printStream;
    private ArrayList<String> boardState;

    public Board(PrintStream printStream, ArrayList<String> boardState) {
        this.printStream = printStream;
        this.boardState = boardState;
    }

    public void drawBoard() {
        StringBuilder boardRepresentation = new StringBuilder();

        for(String position : boardState){
            int boardPosition = Integer.parseInt(position);
            boardRepresentation.append(position);
            if(boardPosition % 3 != 0){
                boardRepresentation.append("|");
            }else {
                boardRepresentation.append("\n");
                if (boardPosition != boardState.size()){
                    boardRepresentation.append("-----\n");
                }
            }
        }
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
