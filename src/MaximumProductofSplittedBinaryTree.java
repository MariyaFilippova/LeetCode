public class MaximumProductofSplittedBinaryTree {
    public int maxProduct(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxProduct(root.left);
        int right = maxProduct(root.right);

        return left > right ? (root.val + right) * left : (root.val + left) * right;
    }
}
