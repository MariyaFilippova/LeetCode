import java.util.List;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode m = l1;
        ListNode n = l2;
        ListNode curr = dummyHead;
        int r = 0;
        while (m != null || n != null) {
            int x = (m != null) ? m.val : 0;
            int y = (n != null) ? n.val : 0;
            int sum = r + x + y;
            r = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (m != null) m = m.next;
            if (n != null) n = n.next;
        }
        if (r > 0) {
            curr.next = new ListNode(r);
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(2);
        l2.next = new ListNode(8);
        l2.next.next = new ListNode(9);
        new AddTwoNumbers().addTwoNumbers(l1, l2);
    }
}
// 1 4  5
// 2 8  9
// 3 2  5 1