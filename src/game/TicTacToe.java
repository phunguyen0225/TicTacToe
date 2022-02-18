package game;

public class TicTacToe {
    private final int SIZE = 3;
    private Peg currentPeg;
    private Peg[][] cells = new Peg[SIZE][SIZE];

    public Peg checkRowMatch() {
        for (int i = 0; i < SIZE; i++) {
            if (cells[i][0] == cells[i][1] && cells[i][1] == cells[i][2] && cells[i][0] != Peg.NONE)
                return cells[i][0];
        }
        return Peg.NONE;
    }

    public Peg checkColumnMatch() {
        for (int i = 0; i < SIZE; i++) {
            if (cells[0][i] == cells[1][i] && cells[1][i] == cells[2][i] && cells[0][1] != Peg.NONE)
                return cells[0][i];
        }
        return Peg.NONE;
    }

    public enum Peg {NONE, SECOND, FIRST};

    public  TicTacToe() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = Peg.NONE;
            }
        }
        currentPeg = Peg.FIRST;
    }

    public Peg winner() {
        Peg winner = checkRowMatch();
        if(winner != Peg.NONE)
            return winner;
        winner = checkColumnMatch();
        return winner;
    }

    public Peg placePeg(int row, int column) {
        if(cells[row][column] == Peg.NONE) {
            cells[row][column] = currentPeg;
            currentPeg = togglePeg();
        }
        return cells[row][column];
    }

    private Peg togglePeg() {
        return (currentPeg == Peg.FIRST) ? Peg.SECOND : Peg.FIRST;
    }
}
