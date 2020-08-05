import java.util.Arrays;

public class MostStonesRemovedwithSameRoworColumn {
    int counter = 0;
    public int removeStones(int[][] stones) {
        if (stones.length == 0) {
            return 0;
        }
        boolean[] visited = new boolean[stones.length];
        for (int i = 0; i < stones.length; i++) {
            if (!visited[i]) {
                counter++;
                dfs(visited, stones, i);
            }
        }
        return stones.length - counter;
    }

    void dfs(boolean[] visited, int[][] stones, int v) {
        if (visited[v]) {
            return;
        }
        visited[v] = true;
        for (int i = 0; i < stones.length; i++) {
            if (i != v && (stones[i][0] == stones[v][0] || stones[i][1] == stones[v][1])) {
                dfs(visited, stones, i);
            }
        }
    }
}
