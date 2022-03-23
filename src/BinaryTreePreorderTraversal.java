import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            if (node.right != null) stack.push(node.right);
            node = node.left;
            if (node == null && !stack.empty()) {
                node = stack.pop();
            }
        }
        return list;
    }
}
