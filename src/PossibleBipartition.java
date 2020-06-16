import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {
        int[] color = new int[N];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : dislikes) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        for (int i = 0; i < color.length; i++) {
            if (color[i] == 0) {
                dfs(1, graph, color, i);
            }
        }
        return Arrays.stream(color).allMatch(a -> a == 3);
    }

    void dfs(int i, List<List<Integer>> graph, int[] color, int v) {
        color[v] = i;
        for (int e : graph.get(v)) {
            if (color[e] == 0)
                dfs(invertColor(i), graph, color, e);
            else if (color[e] == i) {
                return;
            }
        }
        color[v] = 3;
    }

    int invertColor(int i) {
        return i == 2 ? 1 : 2;
    }
}
