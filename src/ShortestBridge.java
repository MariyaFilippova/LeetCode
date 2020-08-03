import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
    boolean found = false;
    int counter = 1;
    boolean[][] visited;
    Queue<int[]> queue = new LinkedList<>();
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        visited = new boolean[A.length][A[0].length];
        for (int i = 0; i < A.length; i++) {
            if (found) {
                break;
            }
            for (int j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(i, j, A);
                    found = true;
                }
                if (found) {
                    break;
                }
            }
        }
        int step = 0;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size != 0) {
                int [] cell = queue.poll();
                for (int[] dir : dirs) {
                    int x = dir[0] + cell[0];
                    int y = dir[1] + cell[1];
                    if (x == -1 || x == A.length || y == -1 || y == A[0].length || visited[x][y]) {
                        continue;
                    }
                    else {
                        if (A[x][y] == 1) {
                            return step;
                        }
                        else {
                            queue.add(new int[]{x, y});
                        }
                        visited[x][y] = true;
                    }
                }
                size--;
            }
            step++;
        }
        return -1;
    }

    void dfs(int i, int j, int[][] A) {
        if (i == -1 || i == A.length || j == -1 || j == A[0].length || visited[i][j] || A[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        queue.add(new int[]{i, j});
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            dfs(x, y, A);
        }
    }

    public static void main(String[] args) {
        new ShortestBridge().shortestBridge(new int[][]{{0,0,1,0,1},{0,1,1,0,1},{0,1,0,0,1},{0,0,0,0,0},{0,0,0,0,0}});
    }
}
