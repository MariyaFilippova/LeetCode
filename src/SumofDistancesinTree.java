import java.util.Arrays;

public class SumofDistancesinTree {
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        Graph graph = new Graph(N);
        int k = edges.length;
        int[] ans = new int[N];
        for (int i = 0; i < k; i++) {
            graph.matrix[edges[i][0]][edges[i][1]] = 1;
            graph.matrix[edges[i][1]][edges[i][0]] = 1;
        }
        for (int i = 0; i < N; i++) {
            ans[i] = Arrays.stream(graph.dijkstraDistance(i, N)).sum();
        }
        return ans;
    }
}
