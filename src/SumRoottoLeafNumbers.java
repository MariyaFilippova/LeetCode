import java.util.ArrayList;
import java.util.List;

public class SumRoottoLeafNumbers {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int path) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return path * 10 + root.val;
        }
        return dfs(root.left, path * 10 + root.val) + dfs(root.right, path * 10 + root.val);
    }
}
