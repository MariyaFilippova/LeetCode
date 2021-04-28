import java.util.*;

public class NumberofRestrictedPathsFromFirsttoLastNode {
    List<List<int []>> adj = new ArrayList<>();
    int counter = 0;

    public int countRestrictedPaths(int n, int[][] edges) {
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e: edges) {
            adj.get(e[0] - 1).add(new int[] {e[1] - 1, e[2]});
            adj.get(e[1] - 1).add(new int[] {e[0] - 1, e[2]});
        }
        int [] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Queue<Integer> queue = new PriorityQueue<>((a, b) -> dist[a] - dist[b]);
        dist[n - 1] = 0;
        queue.add(n - 1);
        dijkstra(n, dist, queue);
        return dfs(0, n, dist, new Integer[n]);
    }

    int dfs(int src, int n, int[] dist, Integer[] memo) {
        if (memo[src] != null) return memo[src];
        if (src == n - 1) return 1;
        int ans = 0;
        for (int[] nei : adj.get(src)) {
            int v = nei[0], w = nei[1];
            if (dist[src] > dist[v])
                ans = (ans + dfs(v, n, dist, memo)) % 1000000007;
        }
        return memo[src] = ans;
    }

    void dijkstra(int n, int [] dist, Queue<Integer> queue) {
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] v : adj.get(node)) {
                if (dist[v[0]] > dist[node] + v[1]) {
                    dist[v[0]] = dist[node] + v[1];
                    queue.add(v[0]);
                }
            }
        }
    }
}
