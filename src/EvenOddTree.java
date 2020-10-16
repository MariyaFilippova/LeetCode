import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int counter = queue.size();
        int level = 0;
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            counter = queue.size();
            while (counter != 0) {
                TreeNode node = queue.poll();
                if (level % 2 == 0) {
                    if (node.val % 2 == 0 || (!list.isEmpty() && list.get(list.size() - 1) > node.val)) {
                        return false;
                    }
                }
                else {
                    if (node.val % 2 != 0 || !list.isEmpty() && list.get(list.size() - 1) < node.val) {
                        return false;
                    }
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                counter--;
                list.add(node.val);
            }
            list.clear();
            level++;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(10);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(7);
        new EvenOddTree().isEvenOddTree(root);
    }
}
