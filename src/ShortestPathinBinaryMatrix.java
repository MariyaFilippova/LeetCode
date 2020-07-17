import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        if (grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) {
            return -1;
        }
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;
        int level = 0;
        int size = 0;
        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        while (!q.isEmpty()) {
            size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                if (cell[0] == grid.length - 1 && cell[1] == grid[0].length - 1) {
                    return level + 1;
                }
                grid[cell[0]][cell[1]] = 1;
                for (int[] dir : dirs) {
                    int x = dir[0] + cell[0];
                    int y = dir[1] + cell[1];
                    if (x != -1 && y != -1 && x != grid.length && y != grid[0].length && grid[x][y] == 0 && grid[x][y] == 0) {
                        q.add(new int[] {x, y});
                        grid[x][y] = 1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public static void main(String[] args) {
        new ShortestPathinBinaryMatrix().shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {1, 1, 0}, {1, 1, 0}});
    }
}
