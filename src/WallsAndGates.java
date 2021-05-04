import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public void wallsAndGates(int[][] rooms) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rooms.length][rooms[0].length];
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int[] cell = queue.poll();
                if (visited[cell[0]][cell[1]]) {
                    size--;
                    continue;
                }
                visited[cell[0]][cell[1]] = true;
                for (int[] dir : dirs) {
                    int x = dir[0] + cell[0];
                    int y = dir[1] + cell[1];
                    if (x == -1 || y == -1 || x == rooms.length || y == rooms[0].length || visited[x][y] || rooms[x][y] == -1) {
                        continue;
                    }
                    rooms[x][y] = Math.min(rooms[cell[0]][cell[1]] + 1, rooms[x][y]);
                    queue.add(new int[]{x, y});
                }
                size--;
            }
        }
    }
}
