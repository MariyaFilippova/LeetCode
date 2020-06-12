import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    Queue<int[][]> or = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int counter = 0;
        build(grid);
        if (or.isEmpty()) {
            return -1;
        }
        int c = 0;
        while (!or.isEmpty()) {
            c = or.size();
            while (c != 0) {
                int[][] orange = or.poll();
                grid[orange[0][0]][orange[0][1]] = -1;
                int[][] g1 = new int[1][2];
                if (orange[0][0] != 0) {
                    if (grid[orange[0][0] - 1][orange[0][1]] == 1) {
                        grid[orange[0][0] - 1][orange[0][1]] = 2;
                        g1[0][0] = orange[0][0] - 1;
                        g1[0][1] = orange[0][1];
                        or.add(g1);
                    }
                }
                int[][] g2 = new int[1][2];
                if (orange[0][0] != grid.length - 1) {
                    if (grid[orange[0][0] + 1][orange[0][1]] == 1) {
                        grid[orange[0][0] + 1][orange[0][1]] = 2;
                        g2[0][0] = orange[0][0] + 1;
                        g2[0][1] = orange[0][1];
                        or.add(g2);
                    }

                }
                int[][] g3 = new int[1][2];
                if (orange[0][1] != 0) {
                    if (grid[orange[0][0]][orange[0][1] - 1] == 1) {
                        grid[orange[0][0]][orange[0][1] - 1] = 2;
                        g3[0][0] = orange[0][0];
                        g3[0][1] = orange[0][1] - 1;
                        or.add(g3);
                    }
                }
                int[][] g4 = new int[1][2];
                if (orange[0][1] != grid[0].length - 1) {
                    if (grid[orange[0][0]][orange[0][1] + 1] == 1) {
                        grid[orange[0][0]][orange[0][1] + 1] = 2;
                        g4[0][0] = orange[0][0];
                        g4[0][1] = orange[0][1] + 1;
                        or.add(g4);
                    }
                }
                c--;
            }
            if (!or.isEmpty())
                counter++;
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return counter;
    }

    void build(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    grid[i][j] = -1;
                    int[][] c = new int[1][2];
                    c[0][0] = i;
                    c[0][1] = j;
                    or.add(c);
                }
            }
        }
    }

    public static void main(String[] args) {
        new RottingOranges().orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}});
    }
}
