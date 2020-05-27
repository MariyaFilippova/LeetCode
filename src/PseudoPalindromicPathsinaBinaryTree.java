import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PseudoPalindromicPathsinaBinaryTree {
    int counter;
    public int pseudoPalindromicPaths (TreeNode root) {
        dfs(root, new int [10]);
        return counter;
    }

    void dfs (TreeNode root, int [] path) {
        if (root == null) {
            return;
        }
        path[root.val]++;
        if (root.left == null && root.right == null) {
            if (isPalindrom(path)) {
                counter++;
            }
        }
        dfs(root.left, path);
        dfs(root.right, path);
        path[root.val]--;
    }

    boolean isPalindrom(int [] path) {
        int localCounter = 0;
        for (int i: path) {
            if (i % 2 != 0) {
                localCounter++;
            }
        }
        return localCounter > 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.right = new TreeNode(5);
        new PseudoPalindromicPathsinaBinaryTree().pseudoPalindromicPaths(root);
    }
}
