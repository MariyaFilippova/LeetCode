import java.util.ArrayList;
import java.util.List;

public class PathwithMaximumGold {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int max = Integer.MIN_VALUE;
    int sum = 0;
    int[][] grid;
    boolean[][] visited;

    public int getMaximumGold(int[][] grid) {
        this.grid = grid;
        int m = grid.length;
        if (m == 0) {
            return 0;
        }
        int n = grid[0].length;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum = 0;
                backtrack(i, j, m, n);
            }
        }
        return max;
    }

    public void backtrack(int i, int j, int m, int n) {
        max = Math.max(max, sum);
        if (i == -1 || j == -1 || i == m || j == n || visited[i][j]) {
            return;
        }
        if (grid[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        sum += grid[i][j];
        for (int[] dir: dirs) {
            int x = i + dir[0];
            int y = j + dir[1];
            backtrack(x, y, m, n);
        }
        visited[i][j] = false;
        sum -= grid[i][j];
    }

    public static void main(String[] args) {
        new PathwithMaximumGold().getMaximumGold(new int [][] {{0,6,0},{5,8,7},{0,9,0}});
    }
}
