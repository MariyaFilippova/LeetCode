public class NumberofClosedIslands {
    int counter;
    int flag;
    public int closedIsland(int[][] grid) {
        if (grid.length == 0) {
            return counter;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    dfs(grid, i, j);
                    if (flag == 0) {
                        counter++;
                    }
                    flag = 0;
                }
            }
        }
        return counter;
    }

    void dfs(int[][] grid, int i, int j) {
        if ((i == 0 || j == 0 || i == grid.length - 1 || j == grid[0].length - 1) && grid[i][j] == 0){
            flag = 1;
            return;
        }
        if (grid[i][j] == 0) {
            grid[i][j] = -1;
            dfs(grid, i + 1, j);
            dfs(grid, i - 1, j);
            dfs(grid, i, j + 1);
            dfs(grid, i, j - 1);
        }
    }

    public static void main(String[] args) {
        new NumberofClosedIslands().closedIsland(new int [][] {{1,1,1,1,1,1,1,0},{1,0,0,0,0,1,1,0},{1,0,1,0,1,1,1,0},{1,0,0,0,0,1,0,1},{1,1,1,1,1,1,1,0}});
    }
}
