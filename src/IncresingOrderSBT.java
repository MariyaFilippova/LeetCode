import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class IncresingOrderSBT {
    public TreeNode increasingBST(TreeNode root) {
        Tree tree = new Tree();
        ArrayList<TreeNode> set = new ArrayList<>();
        DFS(root, set);
        for ( int i = 0; i < set.size(); i++) {
            tree.insert(set.get(i).val);
        }
        return tree.root;
    }

    public void DFS(TreeNode root, ArrayList<TreeNode> set) {
        if (root != null) {
            DFS(root.left, set);
            set.add(root);
            DFS(root.right, set);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new IncresingOrderSBT().increasingBST(tree.root);
    }
}
