import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
    int[][] dirs = new int[][]{{-2, -1}, {-1, -2}, {1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}};

    public int minKnightMoves(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        x = Math.abs(x);
        y = Math.abs(y);

        queue.add(new int[]{0, 0});
        int level = 0;
        set.add(0 + "|" + 0);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int[] cell = queue.poll();
                if (cell[0] == x && cell[1] == y) {
                    return level;
                }
                for (int[] dir : dirs) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (row < -1 || col < -1 || set.contains(row + "|" + col)) {
                        continue;
                    }
                    queue.add(new int[]{row, col});
                    set.add(row + "|" + col);
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
