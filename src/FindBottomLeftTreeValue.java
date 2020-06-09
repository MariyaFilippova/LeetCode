import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int val = 0;
        while(!q.isEmpty()) {
            TreeNode node = q.poll();
            val = node.val;
            if (node.right != null) {
                q.add(node.right);
            }
            if (node.left != null) {
                q.add(node.left);
                val = node.left.val;
            }
        }
        return val;
    }
}
