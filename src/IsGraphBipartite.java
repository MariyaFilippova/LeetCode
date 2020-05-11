import java.util.Arrays;

public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] == 0)
                dfs(graph, i, color, 1);
        }
        return Arrays.stream(color).allMatch(a -> a == 3);
    }

    int invertColor(int i) {
        return i == 1 ? 2 : 1;
    }

    public void dfs(int[][] graph, int v, int[] color, int i) {
        color[v] = i;
        for (int e : graph[v]) {
            if (color[e] == 0) {
                dfs(graph, e, color, invertColor(i));
            } else if (color[e] == i) {
                return;
            }
        }
        color[v] = 3;
    }
}
