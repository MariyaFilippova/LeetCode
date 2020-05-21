public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    void invert(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode node = root.right;
        root.right = root.left;
        root.left = node;
        invert(root.left);
        invert(root.right);
    }
}
