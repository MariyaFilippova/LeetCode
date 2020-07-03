public class DeleteNodeinaBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode mostLeft = min(root.right);
            root.val = mostLeft.val;
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }

    TreeNode min(TreeNode root) {
        if (root.left == null) {
            return root;
        }
        return min(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        new DeleteNodeinaBST().deleteNode(root, 3);
    }
}
