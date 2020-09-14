import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxIncreasetoKeepCitySkyline {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] row = new int[grid[0].length];
        int[] col = new int[grid.length];
        Arrays.fill(row, Integer.MIN_VALUE);
        Arrays.fill(col, Integer.MIN_VALUE);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                row[j] = Math.max(row[j], grid[i][j]);
                col[i] = Math.max(col[i], grid[i][j]);
            }
        }
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                res += Math.min(row[j], col[i]) - grid[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new MaxIncreasetoKeepCitySkyline().maxIncreaseKeepingSkyline(new int[][]{{3,0,8,4},{2,4,5,7},{9,2,6,3},{0,3,1,0}});
    }
}
