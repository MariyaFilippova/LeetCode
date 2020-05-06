import java.util.Scanner;

class LowestCommonAncestorofDeepestLeaves {

    public TreeNode findLca(int one, int two, TreeNode root) {
        if (root == null) {
            return null;
        }
        if (one == root.val || two == root.val) {
            return root;
        }
        TreeNode leftLCA = findLca(one, two, root.left);
        TreeNode rightLCA = findLca(one, two, root.right);
        if (leftLCA != null && rightLCA != null) {
            return root;
        }
        return leftLCA == null ? rightLCA : leftLCA;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new LowestCommonAncestorofDeepestLeaves().findLca(scanner.nextInt(), scanner.nextInt(), tree.root);
    }
}
