import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PathSumII {
    List<List<Integer>> paths = new ArrayList<>();

    public void recursivePathSum(TreeNode root, int sum, List<Integer> nodes) {
        if (root != null && root.right == null && root.left == null) {
            if (sum == root.val) {
                nodes.add(root.val);
                this.paths.add(new ArrayList<>(nodes));
                nodes.remove(nodes.size() - 1);
            }
            return;
        }

        if (root != null) {
            sum = sum - root.val;
            nodes.add(root.val);
            recursivePathSum(root.left, sum, nodes);
            recursivePathSum(root.right, sum, nodes);
            nodes.remove(nodes.size() - 1);
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recursivePathSum(root, sum, new ArrayList<>());
        return this.paths;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = scanner.nextInt();
        Tree tree = new Tree();
        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        new PathSumII().pathSum(tree.root, sum);
    }
}
