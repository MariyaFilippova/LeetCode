import java.util.HashSet;

class FindElements {
    TreeNode root;

    private HashSet<Integer> nodes;

    public FindElements(TreeNode root) {
        if (root == null) {
            return;
        }
        recoverTree(root, 0);
        this.root = root;
    }

    void recoverTree(TreeNode root, int v) {
        if (root == null) {
            return;
        }
        nodes.add(v);
        root.val = v;
        recoverTree(root.left, 2*v + 1);
        recoverTree(root.right, 2*v + 2);
    }

    public boolean find(int target) {
        return nodes.contains(target);
    }
}
