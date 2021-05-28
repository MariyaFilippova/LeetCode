import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class CloneN_aryTree {
    public Node cloneTree(Node root) {
        if (root == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> newQueue = new LinkedList<>();
        queue.add(root);
        Node newRoot = new Node(root.val);
        newQueue.add(newRoot);
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            Node q = newQueue.poll();
            if (p.children == null) {
                continue;
            }
            for (Node child : p.children) {
                if (child == null) {
                    continue;
                }
                Node newChild = new Node(child.val);
                if (q.children == null) {
                    q.children = new ArrayList<>();
                }
                q.children.add(newChild);
                queue.add(child);
                newQueue.add(newChild);
            }
        }
        return newRoot;
    }
}
