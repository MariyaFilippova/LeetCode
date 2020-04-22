import java.util.Scanner;
import java.util.Stack;

public class KthSmallestElInTree {
    public int kthSmallest(TreeNode root, int k) {
        int node = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null && k != 0) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.empty() && k != 0) {
            root = stack.pop();
            if (root.right == null) {
                k--;
                continue;
            } else {
                k--;
                if (k == 0) {
                    return root.val;
                }
                root = root.right;
                while (root != null) {
                    stack.push(root);
                    root = root.left;
                }
            }
        }
        return root.val;
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        int k = scanner.nextInt();
        new KthSmallestElInTree().kthSmallest(tree.root, k);
    }
}
