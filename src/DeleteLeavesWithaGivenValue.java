import java.util.Scanner;

public class DeleteLeavesWithaGivenValue {
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root.left != null)
            root.left = removeLeafNodes(root.left, target);
        if (root.right != null)
            root.right = removeLeafNodes(root.right, target);
        if (root.left == null && root.right == null && root.val == target) {
            return null;
        }
        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree t = new Tree();
        int target = scanner.nextInt();
        while(scanner.hasNextInt()) {
            t.insert(scanner.nextInt());
        }
        new DeleteLeavesWithaGivenValue().removeLeafNodes(t.root, target);
    }
}
