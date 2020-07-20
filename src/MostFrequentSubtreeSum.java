import java.util.*;

public class MostFrequentSubtreeSum {
    int freq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        dfs(root, map);
        for (int i : map.keySet()) {
            if (map.get(i) == freq) {
                res.add(i);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public int dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int val = root.val + dfs(root.left, map) + dfs(root.right, map);
        map.put(val, map.getOrDefault(val, 0) + 1);
        freq = Math.max(freq, map.get(val));
        return val;
    }

}
