public class SmallestStringStartingFromLeaf {
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    String dfs(TreeNode node, String string) {
        if (node == null) {
            return string;
        }
        string = (char)(node.val + 'a') + string;
        if (node.right == null && node.left == null) {
            return string;
        }
        if (node.left == null || node.right == null) {
            return node.left == null ? dfs(node.right, string) : dfs(node.left, string);
        }
        String l = dfs(node.left, string);
        String r = dfs(node.right, string);

        return l.compareTo(r) < 0 ? l : r;
    }
}
