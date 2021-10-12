
public class IslandPerimeter {
    int [][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int [][] visited;

    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0) return 0;
        visited = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) continue;
                return dfs(i, j, grid, 0);
            }
        }
        return 0;
    }

    public int dfs(int i, int j, int[][] grid, int perimeter) {
        if (i == grid.length || i == -1 || j == -1 || j == grid[0].length || grid[i][j] == 0) {
            return perimeter + 1;
        }
        if (visited[i][j] == 1) {
            return perimeter;
        }
        for (int[] dir: dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            visited[i][j] = 1;
            perimeter = dfs(x, y, grid, perimeter);
        }
        return perimeter;
    }
}
