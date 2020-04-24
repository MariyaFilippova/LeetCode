import java.util.Scanner;

import static java.lang.Math.max;

public class LongestPathFromRootToLeave {

    public int pathLongest(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return max(pathLongest(root.left), pathLongest(root.right)) + root.val;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        System.out.println(new LongestPathFromRootToLeave().pathLongest(tree.root));
    }
}
