public class ConvertBSTtoGreaterTree {
    int sum;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }

    void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.right);
        root.val += sum;
        sum = root.val;
        dfs(root.left);
    }
}
