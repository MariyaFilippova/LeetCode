import java.util.ArrayList;
import java.util.List;

public class GraphValidTree {
    int components;

    public boolean validTree(int n, int[][] edges) {
        components = n;
        return !cycle(n, edges);
    }

    boolean cycle(int n, int[][] edges) {
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (int[] edge : edges) {
            int parent_v = parent(parents, edge[0]);
            int parent_u = parent(parents, edge[1]);
            if (parent_u != parent_v) {
                components--;
                parents[parent_u] = parent_v;
            }
            else {
                return true;
            }
        }
        return components > 1;
    }

    int parent(int[] parents, int v) {
        if (v == parents[v]) {
            return v;
        }
        return parents[v] = parent(parents, parents[v]);
    }

    public static void main(String[] args) {
        new GraphValidTree().validTree(5, new int[][]{{0,1},{0,2},{0,3},{1,4}});
    }
}
