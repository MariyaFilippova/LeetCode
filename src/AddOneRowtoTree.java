import java.util.LinkedList;
import java.util.Queue;

public class AddOneRowtoTree {
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int size = 0;
        int level = 1;
        if (d == 1) {
            TreeNode node = new TreeNode(v);
            node.left = root;
            return node;
        }
        while (!queue.isEmpty()) {
            size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (level == d - 1) {
                    TreeNode left = node.left;
                    TreeNode right = node.right;
                    node.left = new TreeNode(v);
                    node.right = new TreeNode(v);
                    node.left.left = left;
                    node.right.right = right;
                    if (left != null) {
                        queue.add(left);
                    }
                    if (right != null) {
                        queue.add(right);
                    }
                } else {
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                size--;
            }
            level++;
        }
        return root;
    }
}
