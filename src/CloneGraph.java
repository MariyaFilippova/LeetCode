import java.util.*;

public class CloneGraph {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> newQueue = new LinkedList<>();
        Map<Integer, Node> cache = new HashMap<>();
        queue.add(node);
        Node root = new Node(node.val);
        newQueue.add(root);
        cache.put(node.val, root);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            Node p = queue.poll();
            Node q = newQueue.poll();
            if (visited.contains(p.val)) {
                continue;
            }
            visited.add(p.val);
            for (Node child: p.neighbors) {
                Node newChild = null;
                if (cache.containsKey(child.val)) {
                    newChild = cache.get(child.val);
                }
                else {
                    newChild = new Node(child.val);
                    cache.put(child.val, newChild);
                }
                if (q.neighbors == null) {
                    q.neighbors = new ArrayList<>();
                }
                q.neighbors.add(newChild);
                if (!visited.contains(child.val)) {
                    queue.add(child);
                    newQueue.add(newChild);
                }
            }
        }
        return root;
    }
}
