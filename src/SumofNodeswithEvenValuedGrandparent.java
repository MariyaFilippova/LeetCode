public class SumofNodeswithEvenValuedGrandparent {
    int sum;
    public int sumEvenGrandparent(TreeNode root) {
        dfs(root, null, null);
        return sum;
    }

    public void dfs (TreeNode root, TreeNode grandParent, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (grandParent != null && grandParent.val % 2 == 0) {
            sum += root.val;
        }
        dfs(root.left, parent, root);
        dfs(root.right, parent, root);

    }
}
