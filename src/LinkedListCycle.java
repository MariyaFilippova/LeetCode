import java.util.HashSet;
import java.util.Set;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (slow.next != null && quick.next.next != null) {
            slow = slow.next;
            quick = quick.next.next;
            if (quick == slow) return true;
        }
        return false;
    }
}
