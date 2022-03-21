public class RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode h = head;
        ListNode prev = null;
        while (h != null) {
            if (prev == null || prev.val != h.val) {
                prev = h;
            }
            else {
                prev.next = h.next;
            }
            h = h.next;
        }
        return head;
    }
}
