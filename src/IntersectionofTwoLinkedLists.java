public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0;
        int m = 0;
        ListNode a = headA;
        ListNode b = headB;
        while (headA != null) {
            headA = headA.next;
            n++;
        }
        while (headB != null) {
            headB = headB.next;
            m++;
        }
        if (n == 0 || m == 0) {
            return null;
        }
        int k = Math.max(m, n) - Math.min(m, n);
        ListNode headF = m > n ? b : a;
        ListNode headS = m <= n ? b : a;
        while (k != 0) {
            headF = headF.next;
            k--;
        }
        while (headF != headS) {
            headF = headF.next;
            headS = headS.next;
        }
        return headF;
    }
}
