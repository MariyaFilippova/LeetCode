import java.util.*;

public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        int[] parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
        for (List<Integer> pair : pairs) {
            int v = find(pair.get(0), parents);
            int u = find(pair.get(1), parents);
            if (u > v) {
                parents[u] = v;
            } else {
                parents[v] = u;
            }
        }

        char[] string = s.toCharArray();
        Map<Integer, PriorityQueue<Character>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = find(i, parents);
            map.putIfAbsent(p, new PriorityQueue<>());
            map.get(p).offer(string[i]);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int p = find(i, parents);
            result.append(map.get(p).poll());
        }
        return result.toString();
    }

    int find(int v, int[] parents) {
        if (parents[v] == v) {
            return v;
        }
        return parents[v] = find(parents[v], parents);
    }
}
