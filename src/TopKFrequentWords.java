import java.util.*;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s : words) {
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                int v = map.get(s);
                map.put(s, v + 1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> b.getValue() == a.getValue() ? symbolBySymbol(a.getKey(), b.getKey()) : b.getValue() - a.getValue());
        q.addAll(map.entrySet());
        List<String> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(q.poll().getKey());
        }
        return list;
    }

    int symbolBySymbol(String a, String b) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) < b.charAt(i)) {
                return -1;
            } else if (a.charAt(i) > b.charAt(i)) {
                return 1;
            }
            i++;
        }
        if (i == a.length()) {
            return -1;
        } else {
            return 1;
        }
    }


}
