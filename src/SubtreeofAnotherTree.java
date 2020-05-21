public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        boolean res = false;
        if (s.val == t.val) {
            res = dfs(s, t);
        }
        return res || isSubtree(s.right, t) || isSubtree(s.left, t);
    }

    public boolean dfs(TreeNode s, TreeNode t) {
        if (t == null && s == null) {
            return true;
        }
        if (s == null || t == null) {
            return false;
        }
        if (s.val != t.val) {
            return false;
        }
        return dfs(s.left, t.left) && dfs(s.right, t.right);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(4);
        node.right = new TreeNode(4);
        new SubtreeofAnotherTree().isSubtree(node, node.right);
    }
}
