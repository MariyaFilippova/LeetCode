public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (q.val > p.val) {
            return commonAncestor(root, p, q);
        }
        return commonAncestor(root, q, p);
    }

    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val <= q.val && root.val >= p.val) {
            return root;
        }
        if (root.val <= p.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return lowestCommonAncestor(root.left, p, q);
    }
}
