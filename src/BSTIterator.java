import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    List<TreeNode> list = new ArrayList<>();
    int pointer = 0;

    public BSTIterator(TreeNode root) {
        dfs(root);
    }

    void dfs(TreeNode node) {
        if (node == null) {
            return;
        }
        dfs(node.left);
        list.add(node);
        dfs(node.right);
    }

    public int next() {
        return list.get(pointer++).val;
    }

    public boolean hasNext() {
        return pointer < list.size();
    }
}
/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
