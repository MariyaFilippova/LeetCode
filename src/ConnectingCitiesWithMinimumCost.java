import java.util.Arrays;
import java.util.PriorityQueue;

public class ConnectingCitiesWithMinimumCost {
    int components = 0;
    int[] parents;
    int cost = 0;

    public int minimumCost(int N, int[][] connections) {
        PriorityQueue<int []> queue = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        components = N;
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
        queue.addAll(Arrays.asList(connections));
        while (components != 1 && !queue.isEmpty()) {
            int [] connection = queue.poll();
            union(connection[0], connection[1], connection[2]);
        }
        if (components != 1) {
            return -1;
        }
        return cost;
    }

    void union(int v, int u, int w) {
        int parent_v = findParent(v);
        int parent_u = findParent(u);
        if (parent_u != parent_v) {
            components--;
            cost += w;
            parents[parent_u] = parent_v;
        }
    }

    int findParent(int v) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = findParent(parents[v]);
    }
}
