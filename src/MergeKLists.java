public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if (k == 0) {
            return null;
        }
        int i = 0;
        while (k > 1) {
            ListNode f = lists[i];
            ListNode s = lists[i + 1];
            lists[i + 1] = MergeTwoSortedLists.mergeTwoLists(f, s);
            k--;
        }
        return lists[lists.length - 1];
    }

    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return mergeKLists(lists, 0, lists.length - 1);
    }

    private ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        } else if (start < end) {
            int mid = (end - start) / 2 + start;
            ListNode left = mergeKLists(lists, start, mid);
            ListNode right = mergeKLists(lists, mid + 1, end);
            return MergeTwoSortedLists.mergeTwoLists(left, right);
        } else {
            return null;
        }
    }
}
