import java.util.ArrayList;
import java.util.List;

public class AllPaths {
    public List<List<Integer>> allPaths(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, root, new ArrayList<>());
        return res;
    }

    void dfs(List<List<Integer>> res, TreeNode root, List<Integer> path) {
        if (root == null ) {
            return;
        }
        path.add(root.val);
        if (root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }
        dfs(res, root.left, path);
        dfs(res, root.right, path);
        path.remove(path.size()-1);
    }
}
