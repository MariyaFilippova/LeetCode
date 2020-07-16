import java.lang.reflect.Array;
import java.util.*;

public class ShortestPathwithAlternatingColors {
    final static int inf = 200000;

    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int[][] dist = new int[2][n];
        int[] res = new int[n];
        boolean[][] visited = new boolean[2][n];
        for (int i = 1; i < n; i++) {
            dist[0][i] = inf;
            dist[1][i] = inf;
        }
        for (int i = 0; i < n; i++) {
            res[i] = -1;
        }
        ArrayList<Integer>[] blue = new ArrayList[n];
        ArrayList<Integer>[] red = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            blue[i] = new ArrayList<>();
            red[i] = new ArrayList<>();
        }
        for (int[] e : red_edges) {
            red[e[0]].add(e[1]);
        }
        for (int[] e : blue_edges) {
            blue[e[0]].add(e[1]);
        }
        while (true) {
            int[] q = getMin(dist, n, visited);
            if (q[0] == -1) {
                for (int j = 0; j < n; j++) {
                    res[j] = Math.min(dist[0][j], dist[1][j]);
                    if (res[j] == inf) {
                        res[j] = -1;
                    }
                }
                break;
            }
            visited[q[1]][q[0]] = true;
            if (q[1] == 1) {
                for (int v : red[q[0]]) {
                    if (dist[0][v] > dist[1][q[0]] + 1) {
                        dist[0][v] = dist[1][q[0]] + 1;
                    }
                }
            }
            if (q[1] == 0) {
                for (int v : blue[q[0]]) {
                    if (dist[1][v] > dist[0][q[0]] + 1) {
                        dist[1][v] = dist[0][q[0]] + 1;
                    }
                }
            }
        }
        return res;
    }

    int[] getMin(int[][] dist, int n, boolean[][] visited) {
        int q = -1;
        int color = -1;
        int min = inf;
        for (int i = 0; i < n; i++) {
            if ((min > dist[0][i] && !visited[0][i])) {
                q = i;
                color = 0;
                min = dist[0][i];
            }
            if (min > dist[1][i] && !visited[1][i]) {
                q = i;
                color = 1;
                min = dist[1][i];
            }
        }
        return new int[] {q, color};
    }

    public static void main(String[] args) {
        new ShortestPathwithAlternatingColors().shortestAlternatingPaths(3, new int[][] {{0, 1}}, new int[][] {{1, 2}});
    }
}
