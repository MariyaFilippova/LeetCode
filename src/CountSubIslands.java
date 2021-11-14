public class CountSubIslands {
    int counter = 0;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1) {
                    counter += dfs(i, j, grid1, grid2);
                }
            }
        }
        return counter;
    }


    private int dfs(int x, int y, int[][] grid1, int[][] grid2) {
        if (x == -1 || y == -1 || x == grid1.length || y == grid1[0].length || grid2[x][y] == 0) {
            return 1;
        }
        if (grid1[x][y] == 0)
            grid2[x][y] = 0;
        int res = dfs(x + 1, y, grid1, grid2);
        res &= dfs(x + 1, y, grid1, grid2);
        res &= dfs(x, y + 1, grid1, grid2);
        res &= dfs(x - 1, y, grid1, grid2);
        res &= dfs(x, y - 1, grid1, grid2);
        return res & grid1[x][y];
    }

    public static void main(String[] args) {
        new CountSubIslands().countSubIslands(new int[][]{{1, 0, 1, 0, 1}, {1, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {1, 0, 1, 0, 1}},
                new int[][]{{0, 0, 0, 0, 0}, {1, 1, 1, 1, 1}, {0, 1, 0, 1, 0}, {0, 1, 0, 1, 0}, {1, 0, 0, 0, 1}});
    }
}
