public class PalindromLinkedList {
    ListNode node;
    public boolean isPalindrome(ListNode head) {
        node = head;
        return palindrome(head);
    }

    boolean palindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        boolean isEnd = palindrome(head.next);
        boolean isEquals = head.val == node.val;
        node = node.next;
        return isEnd && isEquals;
    }
}
