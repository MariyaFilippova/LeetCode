public class CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        return dfs(root);
    }

    int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root.left) + 1 + dfs(root.right);
    }
}
