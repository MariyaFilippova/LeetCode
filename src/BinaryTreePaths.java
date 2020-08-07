import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<StringBuilder> paths = new ArrayList<>();
        dfs(paths, root, new StringBuilder());
        List<String> res = new ArrayList<>();
        for (StringBuilder sb : paths) {
            res.add(sb.toString());
        }
        return res;
    }

    void dfs(List<StringBuilder> paths, TreeNode root, StringBuilder path) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            StringBuilder np = new StringBuilder(path);
            paths.add(np.append(root.val));
            return;
        }
        path.append(root.val);
        StringBuilder np = new StringBuilder(path);
        dfs(paths, root.left, np.append("->"));
        dfs(paths, root.right, path.append("->"));
        path.delete(path.length() - 2, path.length());
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(5);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(9);
        root.left.right = new TreeNode(10);
        new BinaryTreePaths().binaryTreePaths(root);
    }
}
