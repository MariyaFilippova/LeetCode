import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class SortedListToTree {
     public TreeNode sortedListToBST(ListNode head) {
         int size = 0;
         ArrayList<Integer> nums = new ArrayList<>();
         while(head != null) {
             size++;
             nums.add(head.val);
             head = head.next;
         }
         Tree tree = new Tree();
         partition(tree, nums, 0, size - 1);
         return tree.root;
     }
     public void partition (Tree tree, ArrayList<Integer> nums, int start, int end) {
         if (start > end) {
             return;
         }
         int mid = (start + end)/2;
         tree.insert(nums.get(mid));
         partition(tree, nums, start, mid - 1);
         partition(tree, nums, mid+1, end);
     }

    public static void main(String[] args) {
        List<ListNode> list = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i<n; i++) {
            list.add(new ListNode(scanner.nextInt()));
        }
        for (int i = 0; i < n - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        new SortedListToTree().sortedListToBST(list.get(0));
    }
}
