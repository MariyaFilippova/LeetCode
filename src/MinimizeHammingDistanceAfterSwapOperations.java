import java.util.*;

public class MinimizeHammingDistanceAfterSwapOperations {
    int distance = 0;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {

        int[] connected = new int[source.length];
        for (int i = 0; i < connected.length; i++) {
            connected[i] = i;
        }

        for (int i = 0; i < allowedSwaps.length; i++) {
            int u = allowedSwaps[i][0];
            int v = allowedSwaps[i][1];

            int parentU = findParent(u, connected);
            int parentV = findParent(v, connected);
            connected[parentU] = parentV;
        }

        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < source.length; i++) {
            int parent = findParent(i, connected);
            if (!map.containsKey(parent)) {
                Map<Integer, Integer> element = new HashMap<>();
                element.put(source[i], 1);
                map.put(parent, element);
            } else {
                Map<Integer, Integer> element = map.get(parent);
                element.put(source[i], element.getOrDefault(source[i], 0) + 1);
            }
        }

        for (int i = 0; i < target.length; i++) {
            int parent = findParent(i, connected);
            Map<Integer, Integer> element = map.get(parent);
            if (element.containsKey(target[i])) {
                if (element.get(target[i]) != 1) {
                    element.put(target[i], element.get(target[i]) - 1);
                } else {
                    element.remove(target[i]);
                }
            } else {
                distance++;
            }
        }
        return distance;
    }

    int findParent(int u, int[] connected) {
        if (u == connected[u]) {
            return u;
        }
        return connected[u] = findParent(connected[u], connected);
    }

}
