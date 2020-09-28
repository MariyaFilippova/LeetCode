import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class LeastNumberofUniqueIntegersafterKRemovals {
    Map<Integer, Integer> map = new HashMap<>();
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>((a, b) -> (a.getValue() - b.getValue()));

    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                int value = map.get(arr[i]);
                map.put(arr[i], value + 1);
            }
            else {
                map.put(arr[i], 1);
            }
        }
        queue.addAll(map.entrySet());
        while (!queue.isEmpty() && k != 0) {
            Map.Entry<Integer, Integer> entry = queue.peek();
            if (entry.getValue() > 1) {
                entry.setValue(entry.getValue() - 1);
            }
            else {
                queue.poll();
            }
            k--;
        }
        return queue.size();
    }

    public static void main(String[] args) {
        new LeastNumberofUniqueIntegersafterKRemovals().findLeastNumOfUniqueInts(new int[] {4,3,1,1,3,3,2}, 3);
    }
}
