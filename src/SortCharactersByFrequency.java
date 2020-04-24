import java.util.*;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            }
            else {
                map.put(s.charAt(i), 1);
            }
        }
        PriorityQueue<Map.Entry<Character, Integer>> q = new PriorityQueue<>(new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        q.addAll(map.entrySet());
        StringBuilder buf = new StringBuilder();
        while(!q.isEmpty()) {
            Map.Entry<Character, Integer> set = q.poll();
            for (int i = 0; i < set.getValue(); i++) {
                buf.append(set.getKey());
            }
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        new SortCharactersByFrequency().frequencySort(scanner.next());
    }
}
