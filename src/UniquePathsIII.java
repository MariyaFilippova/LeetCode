public class UniquePathsIII {
    int n;
    int m;
    int[][] grid;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int res;
    boolean[][] visited;
    int c;

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        this.m = m;
        this.n = n;
        this.grid = grid;
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == -1) {
                    c++;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, 0);
                }
            }
        }
        return res;
    }

    void dfs(int i, int j, int counter) {
        if (i < 0 || i == n || j == m || j < 0 || grid[i][j] == -1 || visited[i][j]) {
            return;
        }
        counter++;
        if (grid[i][j] == 2 && counter == m * n - c) {
            res++;
            return;
        }
        if (grid[i][j] == 2) {
            return;
        }
        visited[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            dfs(x, y, counter);

        }
        visited[i][j] = false;
        counter--;
    }
}
