import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class AllElementsinTwoBinarySearchTrees {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();
        traverse(root1, res1);
        traverse(root2, res2);
        return merge(res1, res2);
    }

    List<Integer> merge(List<Integer> res1, List<Integer> res2) {
        List<Integer> res = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < res1.size() && j < res2.size()) {
            if (res1.get(i) < res2.get(j)) {
                res.add(res1.get(i));
                i++;
            }
            else {
                res.add(res2.get(j));
                j++;
            }
        }
        while (i < res1.size()) {
            res.add(res1.get(i));
            i++;
        }
        while (j < res2.size()) {
            res.add(res2.get(j));
            j++;
        }

        return res;
    }

    void traverse(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        traverse(root.left, res);
        res.add(root.val);
        traverse(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3);
        root1.right = new TreeNode(4);
        root1.left = new TreeNode(0);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(5);
        new AllElementsinTwoBinarySearchTrees().getAllElements(root1, root2);
    }
}
