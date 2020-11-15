public class RangeSumofBST {
    int sum = 0;

    public int rangeSumBST(TreeNode root, int low, int high) {
        dfs(root, low, high);
        return sum;
    }

    void dfs(TreeNode root, int l, int h) {
        if (root == null) {
            return;
        }
        if (root.val > h) {
            dfs(root.left, l, h);
            return;
        }
        if (root.val < l) {
            dfs(root.right, l, h);
            return;
        }
        dfs(root.left, l, h);
        dfs(root.right, l, h);
        sum += root.val;
    }
}
