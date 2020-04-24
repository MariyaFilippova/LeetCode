import java.util.Scanner;

public class PathSum {
    public boolean recHasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return sum == 0;
        }
        sum = sum - root.val;
        if (root.left == null) {
            return recHasPathSum(root.right, sum);
        }
        if (root.right == null) {
            return recHasPathSum(root.left, sum);
        }
        return recHasPathSum(root.left, sum) || recHasPathSum(root.right, sum);
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return recHasPathSum(root, sum);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        System.out.println(new PathSum().hasPathSum(tree.root, sum));
    }
}
