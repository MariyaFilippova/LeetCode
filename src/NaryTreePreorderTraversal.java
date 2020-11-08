import java.util.ArrayList;
import java.util.List;

public class NaryTreePreorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        preorderTraverse(root);
        return res;
    }

    void preorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        res.add(root.val);
        for (Node node : root.children) {
            preorderTraverse(node);
        }
    }
}
