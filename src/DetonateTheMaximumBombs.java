import java.util.*;

import static java.lang.Math.*;

public class DetonateTheMaximumBombs {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        if (n == 0) return 0;
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double distance = distance(bombs[i][0], bombs[i][1], bombs[j][0], bombs[j][1]);
                if (distance <= bombs[i][2]) {
                    map.get(i).add(j);
                }
                if (distance <= bombs[j][2]) {
                    map.get(j).add(i);
                }
            }
        }
        int max = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dfs(i, visited);
            max = Math.max(max, visited.size());
            visited.clear();
        }
        return max;
    }

    public static double distance(int x1, int y1, int x2, int y2) {
        return sqrt(pow(x1 - x2, 2) + pow(y1 - y2, 2));
    }

    public void dfs(int i, Set<Integer> visited) {
        if (visited.contains(i)) {
            return;
        }
        visited.add(i);
        for (Integer vertex: map.get(i)) {
            dfs(vertex, visited);
        }
    }
}
