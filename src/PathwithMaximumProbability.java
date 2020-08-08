import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class PathwithMaximumProbability {
    int inf = Integer.MAX_VALUE;
    boolean[] visited;
    double[] distance;
    List<List<double []>> e;
    PriorityQueue<Integer> queue;

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        e = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            e.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            e.get(edges[i][0]).add(new double [] {edges[i][1], succProb[i]});
            e.get(edges[i][1]).add(new double [] {edges[i][0], succProb[i]});
        }
        queue = new PriorityQueue<>((i, j) -> (int)(distance[i] - distance[j]));
        distance = new double[n];
        Arrays.fill(distance, 0);
        visited = new boolean[n];
        distance[start] = 1;
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            visited[v] = true;
            for (double[] i : e.get(v)) {
                distance[(int)i[0]] = Math.max(distance[v] * i[1], distance[(int)i[0]]);
                if (!visited[(int)i[0]]) {
                    queue.add((int)i[0]);
                }
            }
        }
        return distance[end];
    }

    public static void main(String[] args) {
        new PathwithMaximumProbability().maxProbability(3, new int[][]{{0, 1}, {1, 2}, {0, 2}}, new double[]{0.5, 0.5, 0.2}, 0, 2);
    }

}
