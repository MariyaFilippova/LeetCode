public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return false;
        }
        dfs(root.right);
        return isSameTrees(root.right, root.left);
    }

    boolean isSameTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }
        return (root1.val == root2.val) && isSameTrees(root1.left, root2.left) && isSameTrees(root1.right, root2.right);
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        dfs(root.left);
        dfs(root.right);
    }
}
