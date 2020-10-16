import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int counter = 0;
        if (root == null) {
            return new ArrayList<>();
        }
        queue.add(root);
        List<Double> res = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            counter = queue.size();
            while (counter != 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                level.add(node.val);
                counter--;
            }
            res.add(level.stream().mapToDouble((s) -> s).sum()/level.size());
            level.clear();
        }
        return res;
    }
}
