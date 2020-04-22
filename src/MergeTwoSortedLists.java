import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ArrayList<ListNode> list = new ArrayList<>();
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                list.add(l2);
                l2 = l2.next;
            }
            else {
                list.add(l1);
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            list.add(l2);
            l2 = l2.next;
        }
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        return list.get(0);
    }
}
