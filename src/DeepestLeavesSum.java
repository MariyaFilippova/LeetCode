import java.util.Scanner;

public class DeepestLeavesSum {
    public int deepestLeavesSum(TreeNode root) {
        return sum(root, maxDepth(root));
    }

    public int sum(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        if (max == 1) {
            return root.val;
        }
        return sum(root.left, max - 1) + sum(root.right, max - 1);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new DeepestLeavesSum().deepestLeavesSum(tree.root);
    }
}
