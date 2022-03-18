public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        int size = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            size++;
        }
        int mid = size/2;
        while (mid != 0) {
            head = head.next;
        }
        return head;
    }
}
