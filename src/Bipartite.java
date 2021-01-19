import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Bipartite {
    static boolean isBipartite = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int v = scanner.nextInt();
        int e = scanner.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < e; i++) {
            int u = scanner.nextInt();
            int q = scanner.nextInt();
            list.get(u - 1).add(q - 1);
            list.get(q - 1).add(u - 1);
        }
        int[] colors = new int[v];
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(visited, colors, list, i, 1);
                if (!isBipartite) {
                    System.out.print("NO");
                    return;
                }
            }
        }
        System.out.print("YES");
    }

    static void dfs(boolean[] visited, int[] colors, List<List<Integer>> list, int i, int color) {
        if (colors[i] == invertColor(color)) {
            isBipartite = false;
            return;
        }
        colors[i] = color;
        visited[i] = true;
        for (int j = 0; j < list.get(i).size(); j++) {
            if (colors[list.get(i).get(j)] != invertColor(color)) {
                dfs(visited, colors, list, list.get(i).get(j), invertColor(color));
            }
        }
    }

    static int invertColor(int color) {
        return color == 1 ? 2 : 1;
    }
}
