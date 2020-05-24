import java.util.ArrayList;
import java.util.List;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        boolean [] visited = new boolean[n];
        List<Integer> local = new ArrayList<Integer>();
        local.add(0);
        dfs(graph, 0, res, local, n, visited);
        return res;
    }

    void dfs(int[][] graph, int v, List<List<Integer>> res, List<Integer> loc,  int n, boolean[] visited) {
        if (v == n - 1) {
            res.add(new ArrayList<>(loc));
            return;
        }

        for (int e : graph[v]) {
            if (!visited[e]) {
                loc.add(e);
                dfs(graph, e, res, loc, n, visited);
                loc.remove(loc.size() - 1);
            }
        }
    }


}
