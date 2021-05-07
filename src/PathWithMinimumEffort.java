import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMinimumEffort {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        Queue<int []> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        queue.add(new int[] {0, 0, 0});
        boolean[][] visited = new boolean[heights.length][heights[0].length];

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = true;
            if (cell[0] == heights.length - 1 && cell[1] == heights[0].length - 1) {
                return cell[2];
            }
            for (int [] dir : dirs) {
                int x = dir[0] + cell[0];
                int y = dir[1] + cell[1];
                if (x == -1 || y == -1 || x == heights.length || y == heights[0].length || visited[x][y]) {
                    continue;
                }
                queue.add(new int[] {x, y, Integer.max(cell[2], Math.abs(heights[x][y] - heights[cell[0]][cell[1]]))});
            }
        }
        return -1;
    }
}
