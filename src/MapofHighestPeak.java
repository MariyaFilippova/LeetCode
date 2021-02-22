import java.util.LinkedList;
import java.util.Queue;

public class MapofHighestPeak {

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int[][] highestPeak(int[][] isWater) {
        if (isWater.length == 0) {
            return new int[][]{};
        }
        int n = isWater.length;
        int m = isWater[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int[][] height = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    int[] cell = new int[]{i, j};
                    queue.add(cell);
                    isWater[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int high = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int[] cell = queue.poll();
                height[cell[0]][cell[1]] = high;
                isWater[cell[0]][cell[1]] = Integer.MAX_VALUE;
                for (int[] dir : dirs) {
                    int x = cell[0] + dir[0];
                    int y = cell[1] + dir[1];
                    if (x < n && x >= 0 && y < m && y >= 0 && isWater[x][y] != Integer.MAX_VALUE) {
                        queue.add(new int[]{x, y});
                        isWater[x][y] = Integer.MAX_VALUE;
                    }
                }
                size--;
            }
            high++;
        }
        return height;
    }
}
