import java.util.*;

public class RedundantConnection {

    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        int[] parents = new int[m];
        for (int i = 0; i < m; i++) {
            parents[i] = i;
        }
        int[] e = new int[2];
        for (int[] edge : edges) {
            if (union(parents, edge[0] - 1, edge[1] - 1)) {
                int u = edge[1] - 1;
                int v = edge[0] - 1;
                int p = find(parents, u);
                int g = find(parents, v);
                parents[p] = g;
            }
            else {
                e = edge;
                break;
            }
        }
        return e;
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


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        int[][] edges = new int[m][2];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scanner.nextInt();
            edges[i][1] = scanner.nextInt();
        }
        new RedundantConnection().findRedundantConnection(edges);
    }
}
