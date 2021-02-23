public class RegionsCutBySlashes {
    int n;

    public int regionsBySlashes(String[] grid) {
        n = grid.length;

        DSU dsu = new DSU(n);
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i > 0)
                    dsu.union(getId(i - 1, j, 2), getId(i, j, 0));
                if (j > 0) dsu.union(getId(i, j - 1, 1), getId(i, j, 3));

                if (grid[i].charAt(j) != '/') {
                    dsu.union(getId(i, j, 0), getId(i, j, 1));
                    dsu.union(getId(i, j, 2), getId(i, j, 3));
                }
                if (grid[i].charAt(j) != '\\') {
                    dsu.union(getId(i, j, 0), getId(i, j, 3));
                    dsu.union(getId(i, j, 2), getId(i, j, 1));
                }
            }
        }
        return dsu.counter;
    }

    int getId(int i, int j, int k) {
        return (i * n + j) * 4 + k;
    }
}

class DSU {
    int[] parent;
    int counter;

    public DSU(int N) {
        counter = N * N * 4;
        parent = new int[N * N * 4];
        for (int i = 0; i < N * N * 4; ++i) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            counter--;
        }
        parent[find(x)] = find(y);
    }
}