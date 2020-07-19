import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        Map<Character, Integer> starts = new HashMap<>();
        Map<Character, Integer> ends = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            if (!starts.containsKey(S.charAt(i))) {
                starts.put(S.charAt(i), i);
            }
            ends.put(S.charAt(i), i);
        }
        List<int[]> segments = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : starts.entrySet()) {
            segments.add(new int[]{entry.getValue(), ends.get(entry.getKey())});
        }
        segments.sort((a, b) -> a[0]-b[0]);
        List<Integer> res = new ArrayList<>();
        int start = segments.get(0)[0];
        int end = segments.get(0)[1];
        for (int i = 1; i < segments.size(); i++) {
            if (end < segments.get(i)[0]) {
                res.add(end - start + 1);
                start = segments.get(i)[0];
                end = segments.get(i)[1];
            }
            else if (end < segments.get(i)[1]) {
                end = segments.get(i)[1];
            }
        }
        res.add(end - start + 1);
        return res;
    }
}
