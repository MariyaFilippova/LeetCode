import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode node = head;
        head = pre;
        while(node != null && node.next != null) {
            pre.next = node.next;
            node.next = pre.next.next;
            pre.next.next = node;
            pre = node;
            node = node.next;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<ListNode> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ListNode(scanner.nextInt()));
        }
        for (int i = 0; i < n -1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        new SwapNodesInPairs().swapPairs(list.get(0));
    }
}
