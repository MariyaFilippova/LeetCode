import java.util.Scanner;

public class MaxDepthOfTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return  searchBST(root.right, val);

    }
    boolean isBinary(TreeNode node) {
        return check(node, -21474836480L, 21474836470L);
    }

    boolean check(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (maxDepth(root.right) - maxDepth(root.left) > 1 || -maxDepth(root.right) + maxDepth(root.left) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        System.out.println(new MaxDepthOfTree().isBinary(tree.root));
    }
}
