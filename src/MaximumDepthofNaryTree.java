public class MaximumDepthofNaryTree {
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int max = 0;
        for (Node node : root.children) {
            int m = maxDepth(node);
            max = Math.max(m, max);
        }
        return max + 1;
    }
}
