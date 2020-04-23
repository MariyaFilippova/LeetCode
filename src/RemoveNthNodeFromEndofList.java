public class RemoveNthNodeFromEndofList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = head;
        ListNode prev = null;
        int size = 0;
        int i = 0;
        while( h != null) {
            h = h.next;
            size++;
        }
        if (size - n == 0) {
            return head.next;
        }
        h = head;
        while (i != size - n) {
            i++;
            prev = h;
            h = h.next;
        }
        prev.next = h.next;
        h = null;
        return head;
    }
}
