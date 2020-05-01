import java.util.Scanner;

import static sun.swing.MenuItemLayoutHelper.max;

class AVL {
    AVLNode root;

    void insert(int key) {
        root = recInsertion(this.root, key);
    }

    private int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }

    private int needBalance(AVLNode node) {
        return node == null ? 0 : getHeight(node.left) - getHeight(node.right);
    }

    private AVLNode leftRotate(AVLNode root) {
        AVLNode node = root.right;
        root.right = node.left;
        node.left = root;
        root.height = max (getHeight(root.right), getHeight(root.left)) + 1;
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    private AVLNode rightRotate(AVLNode root) {
        AVLNode node = root.left;
        root.left = node.right;
        node.right = root;
        root.height = max (getHeight(root.right), getHeight(root.left)) + 1;
        node.height = max(getHeight(node.left), getHeight(node.right)) + 1;
        return node;
    }

    private AVLNode recInsertion(AVLNode root, int key) {
        if (root == null) {
            return new AVLNode(key);
        }
        if (key > root.key) {
            root.right = recInsertion(root.right, key);
        }
        else if (key < root.key) {
            root.left = recInsertion(root.left, key);
        } else
            return root;

        root.height = 1 + max(getHeight(root.right), getHeight(root.left));
        if (needBalance(root) < -1 && key > root.right.key) {
            return leftRotate(root);
        }
        if (needBalance(root) > 1 && key < root.left.key) {
            return rightRotate(root);
        }
        if (needBalance(root) < -1 && key < root.right.key) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        if (needBalance(root) > 1 && key > root.left.key) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        return root;
    }

    public static void main(String[] args) {
        AVL tree = new AVL();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            tree.insert(scanner.nextInt());
        }
    }
}

class AVLNode {
    AVLNode right;
    AVLNode left;
    int key;
    int height;

    AVLNode(int val) {
        this.key = val;
        this.height = 1;
    }

}