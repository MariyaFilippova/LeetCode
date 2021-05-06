import java.util.PriorityQueue;
import java.util.Queue;

public class PathWithMaximumMinimumValue {
    int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int maximumMinimumPath(int[][] A) {
        Queue<int[]> queue = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        int[][] visited = new int[A.length][A[0].length];
        queue.add(new int[]{0, 0, A[0][0]});
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            visited[cell[0]][cell[1]] = 1;
            if (cell[0] == A.length - 1 && cell[1] == A[0].length - 1) {
                return cell[2];
            }
            for (int [] dir : dirs) {
                int x = cell[0] + dir[0];
                int y = dir[1] + cell[1];
                if (x == -1 || y == -1 || x == A.length || y == A[0].length || visited[x][y] == 1) {
                    continue;
                }
                queue.add(new int[] {x, y, Math.min(cell[2], A[x][y])});
            }
        }
        return -1;
    }
}
