import java.util.Scanner;

public class OrderStatisticTree {

    OrderTreeNode root;

    OrderTreeNode getKOrderStatistic(int k, OrderTreeNode root) {
        if (getSize(root.left) + 1 == k) {
            return root;
        } else if (getSize(root.left) + 1 > k) {
            return getKOrderStatistic(k, root.left);
        } else {
            return getKOrderStatistic(k - getSize(root.left) - 1, root.right);
        }
    }

    public void insert(int val) {
        root = recInsertion(val, root);
    }

    public OrderTreeNode recInsertion(int val, OrderTreeNode node) {
        if (node == null) {
            return new OrderTreeNode(val);
        }
        if (node.key <= val) {
            node.right = recInsertion(val, node.right);
        }
        if (node.key > val) {
            node.left = recInsertion(val, node.left);
        }
        updateSize(node);
        return node;
    }

    static private int getSize(OrderTreeNode node) {
        return node == null ? 0 : node.size;
    }

    static void updateSize(OrderTreeNode node) {
        node.size = getSize(node.left) + getSize(node.right) + 1;
    }

    public static void main(String[] args) {
        OrderStatisticTree tree = new OrderStatisticTree();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while (n > 0) {
            tree.insert(scanner.nextInt());
            n--;
        }
        System.out.println(tree.getKOrderStatistic(scanner.nextInt(), tree.root).key);
    }
}

class OrderTreeNode {
    int size;
    int key;
    OrderTreeNode left;
    OrderTreeNode right;

    OrderTreeNode(int x) {
        this.key = x;
        size = 1;
    }
}
