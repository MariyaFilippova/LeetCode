public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return commonAncestor(root, p, q);
    }

    TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = commonAncestor(root.left, p, q);
        TreeNode right = commonAncestor(root.right, p, q);
        if (left != null && right!= null) {
            return root;
        }
        return left == null ? right : left;
    }
}
