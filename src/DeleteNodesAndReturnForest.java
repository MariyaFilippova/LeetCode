import java.util.*;

public class DeleteNodesAndReturnForest {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> forest = new ArrayList<>();
        Set<Integer> delete = new HashSet<>();
        for (int i : to_delete) {
            delete.add(i);
        }
        deleteNodes(root, delete, forest);
        if (!delete.contains(root.val)) {
            forest.add(root);
        }
        forest.add(root);
        return forest;
    }

    TreeNode deleteNodes(TreeNode root, Set<Integer> delete, List<TreeNode> forest) {
        if (root == null) {
            return null;
        }
        root.left = deleteNodes(root.left, delete, forest);
        root.right = deleteNodes(root.right, delete, forest);
        if (delete.contains(root.val)) {
            if (root.left != null) {
                forest.add(root.left);
            }
            if (root.right != null) {
                forest.add(root.right);
            }
            return null;
        }
        return root;
    }
}
