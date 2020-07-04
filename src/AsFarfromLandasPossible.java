import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
    Queue<int[]> q = new LinkedList<>();

    public int maxDistance(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    visited[i][j] = true;
                    q.offer(new int[]{i,j});
                }
            }
        }
        int[][] dirs = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
        int res = -1;
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir: dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x >= 0 && x <grid.length && y >= 0 && y < grid.length && !visited[x][y]) {
                    visited[x][y] = true;
                    grid[x][y] = grid[cell[0]][cell[1]] + 1;
                    res = Math.max(grid[x][y], res);
                    q.offer(new int[]{x, y});
                }
            }
        }
        return res > 0 ? res - 1 : -1;
    }

    public static void main(String[] args) {
        new AsFarfromLandasPossible().maxDistance(new int[][]{{1, 0, 1}, {0, 0, 0}, {1, 0, 1}});
    }
}
