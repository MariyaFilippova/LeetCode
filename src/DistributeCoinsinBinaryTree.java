import java.util.Scanner;

public class DistributeCoinsinBinaryTree {
    int counter;

    public int distributeCoins(TreeNode root) {
        dfs(root);
        return counter;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        counter += left + right;
        return root.val + left + right - 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.root = new TreeNode(0);
        tree.root.left = new TreeNode(0);
        tree.root.right = new TreeNode(2);
        new DistributeCoinsinBinaryTree().dfs(tree.root);
    }
}
