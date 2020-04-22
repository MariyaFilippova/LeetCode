import java.util.Scanner;

public class MaximumLevelSumofaBinaryTree {
    public int maxLevelSum(TreeNode root) {
        int h = maxDepth(root);
        int sum = -100000;
        int level = 0;
        for (int i = 0; i < h; i++) {
            int s = dfs(root, i, 0, 0);
            if (sum < s) {
                sum = s;
                level = i;
            }
        }
        return level + 1;
    }



    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public int dfs(TreeNode root, int d, int h, int sum) {
        if (h == d) {
            return sum + root.val;
        }
        h = h + 1;
        if (root.left != null && root.right != null)
            return dfs(root.left, d, h, sum) + dfs(root.right, d, h, sum);
        if (root.right == null) {
            return dfs(root.left, d, h, sum);
        }
        return dfs(root.right, d, h, sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new MaximumLevelSumofaBinaryTree().maxLevelSum(tree.root);
    }
}
