import java.util.LinkedList;
import java.util.Scanner;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode h = head;
        ListNode p = null;
        while(h != null) {
            ListNode q = h.next;
            h.next = p;
            p = h;
            h = q;
        }
        return p;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        LinkedList<ListNode> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ListNode(scanner.nextInt()));
        }
        for ( int i = 0; i< n - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        new ReverseLinkedList().reverseList(list.getFirst());
    }
}
