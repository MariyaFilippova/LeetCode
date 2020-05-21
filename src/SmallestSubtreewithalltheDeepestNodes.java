public class SmallestSubtreewithalltheDeepestNodes {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        int d = depth(root);
        return dfs(root, d);
    }

    public TreeNode dfs(TreeNode root, int d) {
        if (root == null ) {
            return null;
        }
        if (d == 1) {
            return root;
        }
        TreeNode left = dfs(root.left, d - 1);
        TreeNode right = dfs(root.right, d - 1);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }


    public int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.right), depth(root.left)) + 1;
    }
}
