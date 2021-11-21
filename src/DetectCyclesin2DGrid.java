import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DetectCyclesin2DGrid {
    int[][] dirs = new int[][] {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public boolean containsCycle(char[][] grid) {
        int[][] setted = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (setted[i][j] != -1) {
                    if (dfs(i, j, grid, setted, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int i, int j, char[][] grid, int[][] setted, int lastX, int lastY, char myChar) {
        setted[i][j] = -1;
        boolean hasCycle = false;
        for (int[] dir : dirs) {
            int x = dir[0] + i;
            int y = dir[1] + j;
            if (x != -1 && y != -1 && x != grid.length && y != grid[0].length && grid[x][y] == myChar) {
                if (!(lastX == x && lastY == y)) {
                    if (setted[x][y] == -1) {
                        return true;
                    } else {
                        hasCycle |= dfs(x, y, grid, setted, i, j, myChar);
                    }
                }
            }
        }
        return hasCycle;
    }

    public static void main(String[] args) {
        new DetectCyclesin2DGrid().containsCycle(new char[][]{{'d','b','b'},{'c','a','a'},{'b','a','c'},{'c','c','c'},{'d','d','a'}});
    }
}
