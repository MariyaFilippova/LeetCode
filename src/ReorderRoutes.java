import java.util.*;

public class ReorderRoutes {
    int counter;
    public int minReorder(int n, int[][] connections) {
        boolean visited[] = new boolean[n];
        List<List<Integer>> path = new ArrayList<>();
        for (int i = 0; i<n; i++) {
            path.add(new ArrayList<>());
        }
        for ( int [] connection : connections) {
            path.get(connection[0]).add(connection[1]);
            path.get(connection[1]).add(-connection[0]);
        }
        dfs(path, 0, visited);

        return counter;
    }

    private void dfs(List<List<Integer>> path, int v, boolean[] visited) {
        visited[v] = true;
        for (int e : path.get(v)) {
            if (!visited[Math.abs(e)]) {
                if (e > 0) {
                    counter++;
                }
                dfs(path, Math.abs(e), visited);
            }
        }
    }


    public static void main(String[] args) {
        new ReorderRoutes().minReorder(6, new int [][] {{0,1},{1,3},{2,3},{4,0},{4,5}});
    }
}
