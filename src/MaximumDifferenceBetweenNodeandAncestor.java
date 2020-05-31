public class MaximumDifferenceBetweenNodeandAncestor {
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    int dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return max - min;
        }
        max = Math.max(max, root.val);
        min = Math.min(min, root.val);
        return Math.max(dfs(root.left, max, min), dfs(root.right, max, min));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.right = new TreeNode(2);
        root.left.right = new TreeNode(10);
        root.right.left = new TreeNode(30);
        new MaximumDifferenceBetweenNodeandAncestor().maxAncestorDiff(root);
    }
}
