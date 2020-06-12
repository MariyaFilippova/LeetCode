import java.util.*;

public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        int id = 1;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        int c = 0;
        while (!q.isEmpty()) {
            c = q.size();
            List<Integer> level = new ArrayList<>();
            while (c != 0) {
                TreeNode node = q.poll();
                level.add(node.val);
                if (node.right != null) {
                    q.add(node.right);
                }
                if (node.left != null) {
                    q.add(node.left);
                }
                c--;
            }
            if (id == 1) {
                Collections.reverse(level);
            }
            id = id == 0 ? 1 : 0;
            res.add(level);
        }
        return res;
    }
}
