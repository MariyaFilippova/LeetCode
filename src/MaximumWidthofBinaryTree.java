import java.util.Deque;
import java.util.LinkedList;


public class MaximumWidthofBinaryTree {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.add(root);
        root.val = 1;
        int max = 1;
        int size = 0;
        while (!queue.isEmpty()) {
            size = queue.size();
            max = Math.max(queue.getLast().val - queue.getFirst().val + 1, max);
            while (size != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    node.left.val = node.val * 2;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.val = node.val * 2 + 1;
                    queue.add(node.right);
                }
                size--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        new MaximumWidthofBinaryTree().widthOfBinaryTree(root);

    }
}
