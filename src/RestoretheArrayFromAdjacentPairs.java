import java.util.*;

public class RestoretheArrayFromAdjacentPairs {
    List<Integer> array = new ArrayList<>();
    Map<Integer, List<Integer>> map = new HashMap<>();

    public int[] restoreArray(int[][] adjacentPairs) {
        for (int[] pair: adjacentPairs) {
            if (map.containsKey(pair[0])) {
                map.get(pair[0]).add(pair[1]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[1]);
                map.put(pair[0], list);
            }
            if (map.containsKey(pair[1])) {
                map.get(pair[1]).add(pair[0]);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(pair[0]);
                map.put(pair[1], list);
            }
        }
        int key = 0;
        for (Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
            if (entry.getValue().size() == 1) {
                key = entry.getKey();
                break;
            }
        }
        dfs(key);
        int[] res = new int[array.size()];
        for (int i = 0; i < array.size(); i++) {
            res[i] = array.get(i);
        }
        return res;
    }

    void dfs(int key) {
        if (!map.containsKey(key)) {
            return;
        }
        array.add(key);
        List<Integer> list = map.get(key);
        map.remove(key);
        for (int i : list) {
            dfs(i);
        }
    }
}
