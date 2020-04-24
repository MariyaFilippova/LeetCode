import java.util.Scanner;

public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return pathSumRec(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumRec(TreeNode node, int sum) {
        if (node == null) return 0;
        return (node.val == sum ? 1 : 0)
                + pathSumRec(node.left, sum - node.val) + pathSumRec(node.right, sum - node.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        PathSumIII p = new PathSumIII();
        p.pathSum(tree.root, sum);
    }

}
