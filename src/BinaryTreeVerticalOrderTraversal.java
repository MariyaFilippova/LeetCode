import java.util.*;
import java.util.stream.Collectors;

public class BinaryTreeVerticalOrderTraversal {
    TreeMap<Integer, List<Element>> map = new TreeMap<>();
    static class Element {
        int level;
        int val;

        Element(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(root, 0, 0);
        for (Map.Entry<Integer, List<Element>> entry : map.entrySet()) {
            entry.getValue().sort(Comparator.comparingInt(a -> a.level));
            List<Integer> res = entry.getValue().stream().map(a -> a.val).collect(Collectors.toList());
            list.add(res);
        }
        return list;
    }

    void dfs(TreeNode root, int direction, int level) {
        if (root == null) {
            return;
        }
        List<Element> list = map.getOrDefault(direction, new ArrayList<>());
        list.add(new Element(root.val, level));
        map.put(direction, list);
        dfs(root.left, direction - 1, level + 1);
        dfs(root.right, direction + 1, level + 1);
    }
}
