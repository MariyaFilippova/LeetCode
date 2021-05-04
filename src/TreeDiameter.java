import java.util.*;

public class TreeDiameter {
    List<List<Integer>> adj = new ArrayList<>();

    public int treeDiameter(int[][] edges) {
        for (int i = 0; i < edges.length + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        int v = bfs(0);
        int u = bfs(v);
        return level(u) - 1;
    }

    int level(int i) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        visited.add(i);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                int v = queue.poll();
                visited.add(v);
                for (int vertex : adj.get(v)) {
                    if (!visited.contains(vertex)) {
                        queue.add(vertex);
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }

    int bfs(int i) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        int v = i;
        while (!queue.isEmpty()) {
            v = queue.poll();
            visited.add(v);
            for (int vertex : adj.get(v)) {
                if (!visited.contains(vertex)) {
                    queue.add(vertex);
                }
            }
        }
        return v;
    }

    public static void main(String[] args) {
        System.out.println(new TreeDiameter().treeDiameter(new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 4}, {4, 5}}));
    }
}
