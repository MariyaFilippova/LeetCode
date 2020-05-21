public class BinaryTreePruning {
    public TreeNode pruneTree(TreeNode root) {
        return  dfs(root);
    }

    TreeNode dfs(TreeNode root) {
        root.left = dfs(root.left);
        root.right = dfs(root.right);
        if (root.right == null && root.left == null && root.val == 0) {
            return null;
        }
        else {
            return root;
        }

    }
}
