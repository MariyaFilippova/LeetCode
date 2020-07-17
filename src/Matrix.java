import java.util.LinkedList;
import java.util.Queue;

public class Matrix {
    public int[][] updateMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[][]{};
        }
        int[][] dist = new int[matrix.length][matrix[0].length];
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = cell[1] + dir[1];
                if (x != -1 && y != -1 && x != matrix.length && y != matrix[0].length && !visited[x][y]) {
                    dist[x][y] = dist[cell[0]][cell[1]] + 1;
                    visited[x][y] = true;
                    queue.add(new int[] {x, y});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        new Matrix().updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 0}});
    }
}
