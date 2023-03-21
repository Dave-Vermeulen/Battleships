public class GameBoard {
    private static final int BOARD_SIZE = 10;
    private static final char WATER_CHAR = '-';
    private static final char SHIP_CHAR = 'S';
    private static final char MISS_CHAR = 'O';
    private static final char HIT_CHAR = 'X';

    private char[][] board;

    public GameBoard() {
        this(BOARD_SIZE);
    }

    public GameBoard(int size) {
        this.board = new char[size][size];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                this.board[row][col] = WATER_CHAR;
            }
        }
    }

    public boolean markGuess(int row, int col) {
        switch (board[row][col]) {
            case WATER_CHAR:
                board[row][col] = MISS_CHAR;
                return false;
            case SHIP_CHAR:
                board[row][col] = HIT_CHAR;
                return true;
            default:
                return false;
        }
    }

    public void print() {
        System.out.print("  ");
        for (int col = 0; col < board.length; col++) {
            System.out.print(col + 1 + " ");
        }
        System.out.println();

        for (int row = 0; row < board.length; row++) {
            System.out.print((char) (row + 'A') + " ");
            for (int col = 0; col < board.length; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }
}

