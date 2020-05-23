import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();
        dfs(root1, leaves1);
        dfs(root2, leaves2);
        if(leaves1.size() != leaves2.size()) {
            return false;
        }
        for (int i = 0; i < leaves1.size(); i++) {
            if (!leaves1.get(i).equals(leaves2.get(i))) {
                return false;
            }
        }
        return true;
    }

    void dfs(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        dfs(root.left, leaves);
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
        }
        dfs(root.right, leaves);
    }


}


