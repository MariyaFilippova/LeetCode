import java.util.ArrayList;
import java.util.Scanner;

class NewTree {
    TreeNode root;
    int sum;

    public int getLeftSum(TreeNode node, int direction){
        if (node != null) {
            getLeftSum(node.left, 1);
            if (node.left == null && node.right == null && direction == 1) {
                this.sum = this.sum + node.val;
            }
            getLeftSum(node.right, 0);
        }
        return this.sum;
    }
}


class Solution1 {
//    public static void main(String[] args) {
//        NewTree tree = new NewTree();
//        Scanner s = new Scanner(System.in);
//        while(s.hasNextInt()) {
//            tree.insert(s.nextInt());
//        }
//        new Solution1().sumOfLeftLeaves(tree.root, tree);
//    }

    public int sumOfLeftLeaves(TreeNode root) {
        NewTree tree = new NewTree();
        tree.root = root;
        int direction = -1;
        return tree.getLeftSum(root, -1);
    }
}