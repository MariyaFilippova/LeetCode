public class SumofRootToLeafBinaryNumbers {
    int sum;

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, "");
    }

    int dfs(TreeNode root, String binary) {
        if (root == null) {
            return 0;
        }
        binary += root.val;
        if (root.left == null && root.right == null) {
            return Integer.parseInt(binary, 2);
        }
        return dfs(root.left, binary) + dfs(root.right, binary);
    }
}
