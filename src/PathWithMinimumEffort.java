import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathWithMinimumEffort {
    int height = Integer.MAX_VALUE;
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        if (n == 0) {
            return 0;
        }
        int m = heights[0].length;
        int[] distances = new int[n * m];
        Arrays.fill(distances, Integer.MAX_VALUE);
        return height;
    }

    public static void main(String[] args) {
        new PathWithMinimumEffort().minimumEffortPath(new int[][] {{1,2,2}, {3,8,2}, {5,3,5}});
    }
}
