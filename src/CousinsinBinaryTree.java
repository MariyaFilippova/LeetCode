public class CousinsinBinaryTree {
    int depth;
    TreeNode parent;

    public boolean isCousins(TreeNode root, int x, int y) {
        depth(root, x, 0);
        int d1 = depth;
        depth(root, y, 0);
        int d2 = depth;
        if (d1 != d2) {
            return false;
        }
        getParent(root, null, x);
        TreeNode p1 = parent;
        getParent(root, null, y);
        TreeNode p2 = parent;
        if (p1.val == p2.val) {
            return false;
        }
        return true;
    }

    void getParent(TreeNode root, TreeNode parent, int x) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            this.parent = parent;
        }
        getParent(root.left, root, x);
        getParent(root.right, root, x);
    }

    void depth(TreeNode root, int x, int d) {
        if (root == null) {
            return;
        }
        if (root.val == x) {
            depth = d;
        }
        depth(root.left, x, d + 1);
        depth(root.right, x, d + 1);
    }
}
