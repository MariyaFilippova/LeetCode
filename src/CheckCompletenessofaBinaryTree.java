import java.util.LinkedList;
import java.util.Queue;

public class CheckCompletenessofaBinaryTree {
    public boolean isCompleteTree(TreeNode root) {
        return bfs(root);
    }

    boolean bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        int c = 0;
        q.add(root);
        while (!q.isEmpty()) {
            c = q.size();
            while (c != 0) {
                TreeNode node = q.poll();
                if (node == null && checkNotNullQueue(q)) {
                    return false;
                }
                if (node == null) {
                    return true;
                }
                q.add(node.left);
                q.add(node.right);
                c--;
            }
        }
        return true;
    }

    boolean checkNotNullQueue(Queue<TreeNode> q) {
        for (TreeNode e : q) {
            if (e != null) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        new CheckCompletenessofaBinaryTree().isCompleteTree(root);
    }
}
