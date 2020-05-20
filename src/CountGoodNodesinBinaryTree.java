public class CountGoodNodesinBinaryTree {
    int counter;
    public int goodNodes(TreeNode root) {
        dfs(-1000000, root);
        return counter;
    }

    public void dfs(int max, TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(max, root.left);
        if (max <= root.val) {
            counter++;
            max = root.val;
        }
        dfs(max, root.left);
        dfs(max, root.right);
    }

    public static void main(String[] args) {
        TreeNode n = new TreeNode(3);
        n.left = new TreeNode(3);
        n.right = new TreeNode(2);
        new CountGoodNodesinBinaryTree().goodNodes(n);
    }
}
