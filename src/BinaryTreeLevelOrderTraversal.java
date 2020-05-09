import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return levels;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int s = queue.size();
            TreeNode node = queue.poll();
            while (s != 0) {
                level.add(node.val);
                if (root.left != null) {
                    queue.add(node.left);
                }
                if (root.right != null) {
                    queue.add(node.right);
                }
                s--;
            }
            levels.add(level);
        }
        return levels;
    }
}
