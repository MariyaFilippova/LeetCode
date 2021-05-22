import java.util.HashSet;

public class TwoSumBSTs {
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        HashSet<Integer> set1 = new HashSet<>();
        dfs(root1, set1, target);
        return traverse(root2, set1);
    }

    boolean traverse(TreeNode node, HashSet<Integer> set) {
        if (node == null) {
            return false;
        }
        if (set.contains(node.val)) {
            return true;
        }
        boolean left = traverse(node.left, set);
        boolean right = traverse(node.right, set);
        return left || right;
    }

    void dfs(TreeNode node, HashSet<Integer> set, int target) {
        if (node == null) {
            return;
        }
        dfs(node.left, set, target);
        set.add(target - node.val);
        dfs(node.right, set, target);
    }
}
