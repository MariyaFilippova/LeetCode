import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix.length == 0) {
            return result;
        }
        int[][] atlantic = new int[matrix.length][matrix[0].length];
        int[][] pacific = new int[matrix.length][matrix[0].length];
        Queue<int []> queue = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            pacific[i][0] = 1;
            queue.add(new int[]{i, 0});
        }
        for (int i = 0; i < matrix[0].length; i++) {
            pacific[0][i] = 1;
            queue.add(new int[]{0, i});
        }
        int[][] dirs = new int[][]{{1,0}, {0,1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int [] cell = queue.poll();
            for (int[] dir: dirs) {
                int x = dir[0] + cell[0];
                int y = dir[1] + cell[1];
                if (x != -1 && y!= -1 && x != matrix.length && y != matrix[0].length && matrix[x][y] >= matrix[cell[0]][cell[1]] && pacific[x][y] == 0) {
                    pacific[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        for (int i = matrix.length - 1; i >=0 ; i--) {
            atlantic[i][matrix[0].length - 1] = 1;
            queue.add(new int[]{i, matrix[0].length - 1});
        }
        for (int i = matrix[0].length - 1; i >= 0; i--) {
            atlantic[matrix.length - 1][i] = 1;
            queue.add(new int[]{matrix.length - 1, i});
        }
        while (!queue.isEmpty()) {
            int [] cell = queue.poll();
            for (int[] dir: dirs) {
                int x = dir[0] + cell[0];
                int y = dir[1] + cell[1];
                if (x != -1 && y!= -1 && x != matrix.length && y != matrix[0].length && matrix[x][y] >= matrix[cell[0]][cell[1]] && atlantic[x][y] == 0) {
                    atlantic[x][y] = 1;
                    queue.add(new int[]{x, y});
                }
            }
        }
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> cell = new ArrayList<>();
                    cell.add(i, j);
                    result.add(cell);
                }
            }
        }
        return result;
    }
}
