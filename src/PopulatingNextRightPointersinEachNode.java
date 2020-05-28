import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PopulatingNextRightPointersinEachNode {
    public RNode connect(RNode root) {
        if (root == null) {
            return null;
        }
        bfs(root);
        return root;
    }

    void bfs(RNode root) {
        Queue<RNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int counter = q.size();
            ArrayList<RNode> level = new ArrayList<>();
            while (counter != 0) {
                RNode node = q.poll();
                level.add(node);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                counter--;
            }
            connect(level);
        }
    }

    void connect(ArrayList<RNode> level) {
        if (level.size() == 1) {
            level.get(0).next = null;
            return;
        }
        for (int i = 0; i < level.size() - 1; i++) {
            level.get(i).next = level.get(i + 1);
        }
        level.get(level.size() - 1).next = null;
    }
}

class RNode {
    public int val;
    public RNode left;
    public RNode right;
    public RNode next;

    public RNode() {
    }

    public RNode(int _val) {
        val = _val;
    }

    public RNode(int _val, RNode _left, RNode _right, RNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};