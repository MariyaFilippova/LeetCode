import java.util.LinkedList;
import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution3 {
    public static void main(String[] args) {
        Tree tree = new Tree();
        Scanner scanner = new Scanner((System.in));
        int n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            tree.insert(scanner.nextInt());
        }
        int m = scanner.nextInt();
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        for (int i = 0; i < m; i++) {
            list.add(new ListNode(scanner.nextInt()));
        }
        for (int i = 0; i < m; i++) {
            if (i == m - 1) {
                list.get(i).next = null;
            } else {
                list.get(i).next = list.get(i + 1);
            }

        }
        new Solution3().isSubPath(list.getFirst(), tree.root);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean dfs(ListNode head, TreeNode root) {
        if (head == null) return true;
        if (root == null) return false;
        return head.val == root.val && (dfs(head.next, root.left) || dfs(head.next, root.right));
    }
}