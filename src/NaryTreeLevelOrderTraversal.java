import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
    public int val;
    public List<Node> children;
    public List<Node> neighbors;

    public Node() {}
    public Node left;
    public Node right;
    public Node parent;
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class NaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> levels = new LinkedList<>();
        Queue<Node> queue = new LinkedList<>();
        if (root == null) {
            return levels;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int s = queue.size();
            List<Integer> level = new ArrayList<>();
            while (s > 0) {
                Node node = queue.poll();
                level.add(node.val);
                if (node.children != null) {
                    queue.addAll(node.children);
                }
                s--;
            }
            levels.add(level);
        }
        return levels;
    }
}
