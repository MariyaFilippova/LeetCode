import java.lang.reflect.Array;
import java.util.*;

public class AllNodesDistanceKinBinaryTree {
    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
        buildGraph(root, null);
        return bfs(K, target);
    }

    void buildGraph(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(root)) {
            map.put(root, new ArrayList<>());
        }
        if (parent != null) {
            map.get(root).add(parent);
        }
        if (root.left != null) {
            map.get(root).add(root.left);
        }
        if (root.right != null) {
            map.get(root).add(root.right);
        }
        buildGraph(root.left, root);
        buildGraph(root.right, root);
    }

    List<Integer> bfs(int k, TreeNode target) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();
        queue.add(target);
        visited.add(target);
        while (!queue.isEmpty() && k != 0) {
            int c = queue.size();
            while (c != 0) {
                TreeNode node = queue.poll();
                for (TreeNode n : map.get(node)) {
                    if (!visited.contains(n)) {
                        queue.add(n);
                        visited.add(n);
                    }
                }
                c--;
            }
            k--;
        }
        for (TreeNode node: queue) {
            res.add(node.val);
        }
        return res;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right = new TreeNode(2);
        new AllNodesDistanceKinBinaryTree().distanceK(root, root.left, 2);
    }
}
