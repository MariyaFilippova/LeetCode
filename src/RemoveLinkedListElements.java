public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        ListNode node = head;
        ListNode prev = head;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
            }
            else {
                prev = node;
            }
            node = node.next;
        }
        return head;
    }
}
