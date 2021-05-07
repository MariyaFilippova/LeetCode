import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<TreeNode> list = new ArrayList<>();
        traverse(root, list);
        root = list.get(0);
        TreeNode node = root;
        for (int i = 1; i < list.size(); i++) {
            root.right = list.get(i);
            root = root.right;
        }
        root.right = node;
        Collections.reverse(list);
        root = list.get(0);
        node = root;
        for (int i = 1; i < list.size(); i++) {
            root.left = list.get(i);
            root = root.left;
        }
        root.left = node;
        return root;
    }

    void traverse(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        traverse(node.left, list);
        list.add(node);
        traverse(node.right, list);
    }
}
