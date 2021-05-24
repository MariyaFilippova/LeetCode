import java.util.LinkedList;
import java.util.Queue;

public class FindNearestRightNodeinBinaryTree {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node == u) {
                    if (size == 1) {
                        return null;
                    }
                    else {
                        return queue.poll();
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
        }
        return null;
    }
}
