import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int c = 0;
        int val = 0;
        while(!q.isEmpty()) {
            c = q.size();
            while (c != 0) {
                TreeNode node = q.poll();
                val = node.val;
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                    val = node.left.val;
                }
                c--;
            }
        }
        return val;
    }
}
