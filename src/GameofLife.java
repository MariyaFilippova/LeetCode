public class GameofLife {
    // 1 -> 0   2
    // 0 -> 1   3

    int n;
    int m;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    int[][] board;

    public void gameOfLife(int[][] board) {
        n = board.length;
        if (n == 0) {
            return;
        }
        m = board[0].length;
        this.board = board;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int live = neighbors(i, j);
                if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 3;
                }
                if (board[i][j] == 1) {
                    if (live < 2 || live > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int neighbors(int i, int j) {
        int live = 0;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x == -1 || y == -1 || x == n || y == m) {
                continue;
            }
            if (board[x][y] == 2 || board[x][y] == 1) {
                live++;
            }
        }
        return live;
    }
}
