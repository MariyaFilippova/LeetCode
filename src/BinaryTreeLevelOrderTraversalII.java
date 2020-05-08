import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new ArrayList<>();
        int h = maxDepth(root);
        for (int i = h; i > 0; i--) {
            List<Integer> level = new ArrayList<>();
            levelOrder.add(level);
            bfs(root, h, level);
        }
        return levelOrder;
    }

    public void bfs(TreeNode root, int h, List<Integer> levelOrder) {
        if (root == null) {
            return;
        }
        bfs(root.left, h - 1, levelOrder);
        if (h == 1) {
            levelOrder.add(root.val);
        }
        bfs(root.right, h - 1, levelOrder);
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

}
