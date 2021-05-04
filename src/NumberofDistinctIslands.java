import java.util.HashSet;
import java.util.Set;

public class NumberofDistinctIslands {
    int[][] dirs = new int[][]{{0, 1, 1}, {1, 0, 2}, {-1, 0, 3}, {0, -1, 4}};
    Set<String> set = new HashSet<>();

    public int numDistinctIslands(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    StringBuilder stringBuilder = new StringBuilder();
                    dfs(grid, i, j, visited, 0, stringBuilder);
                    set.add(stringBuilder.toString());
                }
            }
        }
        return set.size();
    }

    void dfs(int[][] grid, int i, int j, boolean[][] visited, int direction, StringBuilder stringBuilder) {
        if (i == -1 || j == -1 || i == grid.length || j == grid[0].length || visited[i][j] || grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        stringBuilder.append(direction);
        for (int[] dir : dirs) {
             int x = i + dir[0];
             int y = j + dir[1];
             dfs(grid, x, y, visited, dir[2], stringBuilder);
        }
        stringBuilder.append(0);
    }

    public static void main(String[] args) {
        new NumberofDistinctIslands().numDistinctIslands(new int[][] {{1,1,0,0,0}, {1,1,0,0,0},{0,0,0,1,1},{0,0,0,1,1}});
    }
}
