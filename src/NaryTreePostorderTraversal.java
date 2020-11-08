import java.util.ArrayList;
import java.util.List;

public class NaryTreePostorderTraversal {
    List<Integer> res = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        postorderTraverse(root);
        return res;
    }

    void postorderTraverse(Node root) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            postorderTraverse(node);
        }
        res.add(root.val);
    }
}
