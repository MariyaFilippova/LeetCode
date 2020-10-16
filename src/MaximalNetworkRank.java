import java.util.HashMap;
import java.util.Map;

public class MaximalNetworkRank {
    public int maximalNetworkRank(int n, int[][] roads) {
        if (n == 0) {
            return 0;
        }
        if (roads.length == 0) {
            return 0;
        }
        int[] edges = new int[n];
        int[][] connected = new int[n][n];

        for (int[] road : roads) {
            edges[road[0]]++;
            edges[road[1]]++;
            connected[road[0]][road[1]] = 1;
            connected[road[1]][road[0]] = 1;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                max = Math.max(max, edges[i] + edges[j] - connected[i][j]);
            }

        }
        return max;
    }
}
