import java.util.ArrayList;
import java.util.Scanner;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Tree {
    TreeNode root;
    int sum;
    ArrayList<TreeNode> nodes;

    Tree() {
        this.nodes = new ArrayList<>();
    }

    public void insert(int val) {
        root = recInsertion(val, root);
    }

    // меняет каждый узел, чтобы в каждом узле была сумма всех больших элементов
    public Tree modify(TreeNode node) {
        if (node != null) {
            modify(node.right);
            this.sum = node.val + this.sum;
            node.val = this.sum;
            modify(node.left);
        }
        return this;
    }

    public ArrayList<TreeNode> print(TreeNode node) {
        if (node != null) {
            print(node.left);
            this.nodes.add(node);
            print(node.right);
        }
        return this.nodes;
    }

    public int height(TreeNode node) {
        int right = 0;
        int left = 0;
        if (node == null) {
            return 0;
        }
        if (node.right != null) {
            right = height(node.right);
        }
        if (node.left != null) {
            left = height(node.left);
        }
        return Math.max(right, left) + 1;
    }


    public TreeNode recInsertion(int val, TreeNode node) {
        if (node == null) {
            return new TreeNode(val);
        }
        if (node.val <= val) {
            node.right = recInsertion(val, node.right);
        }
        if (node.val > val) {
            node.left = recInsertion(val, node.left);
        }
        return node;
    }

    boolean isBinary(TreeNode node) {
        return check(node, -21474836480L, 21474836470L);
    }

    boolean check(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val < min || node.val > max) {
            return false;
        }
        return check(node.left, min, node.val) && check(node.right, node.val, max);
    }



    public TreeNode sortedArrayToBST(ArrayList<TreeNode> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end)/2;
        this.insert(nodes.get(mid).val);
        sortedArrayToBST(nodes, start, mid - 1);
        sortedArrayToBST(nodes, mid + 1, end);
        return this.root;//
    }
}

class Solution {
    public TreeNode balanceBST(TreeNode root,Tree tree) {
        Tree tree1 = new Tree();
        ArrayList<TreeNode> nodes = tree.print(root);
        int start = 0;
        int end = nodes.size() - 1;
        return tree1.sortedArrayToBST(nodes, start, end);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner s = new Scanner(System.in);
        while(s.hasNextInt()) {
            tree.insert(s.nextInt());
        }
        new Solution().balanceBST(tree.root, tree);
    }
}

