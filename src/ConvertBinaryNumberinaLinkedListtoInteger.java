public class ConvertBinaryNumberinaLinkedListtoInteger {
    StringBuilder sb = new StringBuilder();

    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return Integer.parseInt(sb.toString(), 2);
        }
        sb.append(head.val);
        return getDecimalValue(head.next);
    }
}
