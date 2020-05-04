import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TopologicalSort {
    static final int inf = 1000000;

    static boolean checkForCycle(int[][] matrix) {
        int n = matrix.length;
        int[] color = new int[n];
        for (int i = 0; i < n; i++) {
            if (color[i] != 2) {
                dfsCycle(matrix, i, color);
            }
        }
        return !Arrays.stream(color).allMatch(a -> a== 2);
    }

    private static void dfsCycle(int[][] matrix, int v, int[] color) {
        color[v] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[v][i] != inf) {
                if (color[i] == 0)
                    dfsCycle(matrix, i, color);
                if (color[i] == 1) {
                    return;
                }
            }
        }
        color[v] = 2;
    }

    private static void dfs(List<Integer> vertexes, int[][] matrix, int v, boolean[] visited) {
        int n = matrix.length;
        visited[v] = true;
        for (int i = 0; i < n; i++) {
            if (matrix[v][i] != inf && !visited[i]) {
                dfs(vertexes, matrix, i, visited);
            }
        }
        vertexes.add(v);
    }

     static List<Integer> topologicalSort(int[][] matrix) {
        int n = matrix.length;
        List<Integer> vertexes = new LinkedList<>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i])
                dfs(vertexes, matrix, i, visited);
        }
        return vertexes;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = inf;
            }
        }
        int k = scanner.nextInt();
        for (int i = 0; i < k; i++) {
            matrix[scanner.nextInt()][scanner.nextInt()] = 1;
        }
        System.out.println(TopologicalSort.checkForCycle(matrix));
    }
}
