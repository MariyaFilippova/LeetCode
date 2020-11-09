import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumDeletionstoMakeCharacterFrequenciesUnique {
    int counter = 0;

    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        Map<Integer, Integer> freq = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (freq.containsKey(value)) {
                freq.put(value, freq.get(value) + 1);
            } else {
                freq.put(value, 1);
            }
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((a, b) -> (a.getValue() - b.getValue()));
        boolean isEnd;
        while (true) {
            isEnd = true;
            queue.addAll(freq.entrySet());
            while (!queue.isEmpty()) {
                Map.Entry<Integer, Integer> entry = queue.poll();
                int value = entry.getValue();
                int key = entry.getKey();
                if (value == 1) {
                    freq.put(key, freq.get(key));
                } else {
                    isEnd = false;
                    counter++;
                    if (key == 1) {
                        freq.put(key, freq.get(key) - 1);
                        continue;
                    }
                    freq.put(key, freq.get(key) - 1);
                    if (!freq.containsKey(key - 1)) {
                        freq.put(key - 1, 1);
                    }
                    else {
                        freq.put(key - 1, freq.get(key - 1) + 1);
                    }
                }
            }
            if (isEnd) {
                return counter;
            }
        }
    }
}
