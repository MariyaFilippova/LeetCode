import java.util.*;

public class FindLargestValueinEachTreeRow {
    public List<Integer> largestValues(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> level = new ArrayList<>();
        if (root == null) {
            return level;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int max = -2147483648;
            int s = queue.size();
            while (s != 0) {
                TreeNode node = queue.poll();
                if (max < node.val) {
                    max = node.val;
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                s--;
            }
            level.add(max);
        }
        return level;
    }
}
