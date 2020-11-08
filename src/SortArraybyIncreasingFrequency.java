import java.util.*;

public class SortArraybyIncreasingFrequency {
    public int[] frequencySort(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? b.getKey() - a.getKey() : a.getValue() - b.getValue());
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        queue.addAll(map.entrySet());
        int[] a = new int[nums.length];
        int i = 0;
        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> entry = queue.poll();
            int key = entry.getKey();
            int value = entry.getValue();
            while (value != 0) {
                a[i] = key;
                i++;
                value--;
            }
        }
        return a;
    }
}
