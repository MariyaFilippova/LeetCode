import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char [] c = strs[i].toCharArray();
            Arrays.sort(c);
            if (!map.containsKey(String.valueOf(c))) {
                map.put(String.valueOf(c), new ArrayList<>());
            }
            map.get(String.valueOf(c)).add(i);
        }
        for (Map.Entry<String, List<Integer>> entry: map.entrySet()) {
            res.add(new ArrayList<>());
            for (int i  : entry.getValue()) {
                res.get(res.size() - 1).add(strs[i]);
            }
        }
        return res;
    }
}
