public class NumberOfConnectedComponentsInAnUndirectedGraph {
    private int count;
    public int countComponents(int n, int[][] edges) {
        if (n == 0 || edges.length == 0) {
            return 0;
        }
        count = n;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] e: edges) {
            int v = findParent(e[0], parents);
            int u = findParent(e[1], parents);
            if (u != v) {
                count--;
                parents[u] = v;
            }
        }
        return count;
    }

    int findParent(int v, int[] parents) {
        if(v == parents[v]) {
            return v;
        }
        return parents[v] = findParent(parents[v], parents);
    }
}
