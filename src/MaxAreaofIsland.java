public class MaxAreaofIsland {
    public int maxAreaOfIsland(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int counter = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 1) {
                    int local = dfs(grid, i, j, r, c);
                    if (local > counter) {
                        counter = local;
                    }
                }
            }
        }
        return counter;
    }

    public int dfs(int[][] grid, int i, int j, int r, int c) {
        if (i < 0 || i > r - 1 || j < 0 || j > c - 1) {
            return 0;
        }
        if (grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        return dfs(grid, i+1, j, r, c) + dfs(grid, i-1, j, r, c) + dfs(grid, i, j+ 1 , r, c) + dfs(grid, i, j - 1, r, c) + 1;
    }
}
