import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TwoSumIVInputisaBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        treeInOrder(root, list);
        int i = 0;
        int j = list.size() -1;
        while (i < j) {
            if (list.get(i) + list.get(j) == k) {
                return true;
            }
            else if (list.get(i) + list.get(j) < k) {
                i++;
            }
            else {
                j--;
            }
        }
        return false;
    }

    public void treeInOrder(TreeNode root, List<Integer> nodes) {
        if (root !=null) {
            treeInOrder(root.left, nodes);
            nodes.add(root.val);
            treeInOrder(root.right, nodes);
        }
    }
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        for (int i = 0 ; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new TwoSumIVInputisaBST().findTarget(tree.root,k );
    }
}
