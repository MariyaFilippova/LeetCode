public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        int counter = n;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (M[i][j] == 1) {
                    if (union(parents, i, j)) {
                        int v = find(parents, i);
                        int u = find(parents, j);
                        parents[u] = v;
                        counter--;
                    }
                }
            }
        }
        return counter;
    }

    public boolean union(int[] parents, int v, int u) {
        return !(find(parents, v) == find(parents, u));
    }

    public int find(int[] parents, int v) {
        if (v == parents[v]) {
            return v;
        }
        return find(parents, parents[v]);
    }
}
