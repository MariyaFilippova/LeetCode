public class TicTacToe {
    int[][] rows;
    int[][] cols;
    int[][] diag;
    int n;

    /**
     * Initialize your data structure here.
     */
    public TicTacToe(int n) {
        this.n = n;
        rows = new int[2][n];
        cols = new int[2][n];
        diag = new int[2][2];
    }

    /**
     * Player {player} makes a move at ({row}, {col}).
     *
     * @param row    The row of the board.
     * @param col    The column of the board.
     * @param player The player, can be either 1 or 2.
     * @return The current winning condition, can be either:
     * 0: No one wins.
     * 1: Player 1 wins.
     * 2: Player 2 wins.
     */
    public int move(int row, int col, int player) {
        if (++rows[player - 1][row] == n || ++cols[player - 1][col] == n) {
            return player;
        }
        if (row == col && ++diag[player - 1][0] == n) {
            return player;
        }
        if (row == n - col - 1 && ++diag[player - 1][1] == n) {
            return player;
        }
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
