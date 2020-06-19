import java.util.LinkedList;
import java.util.List;

class LinkedNode {
    public int val;
    public LinkedNode prev;
    public LinkedNode next;
    public LinkedNode child;
};

class FlattenaMultilevelDoublyLinkedList {
    List<LinkedNode> chain = new LinkedList<>();

    public LinkedNode flatten(LinkedNode head) {
        if (head == null) {
            return null;
        }
        dfs(head);
        LinkedNode node = chain.get(0);
        for (int i = 1; i < chain.size(); i++) {
            node.next = chain.get(i);
            node.child = null;
            node = chain.get(i);
        }
        node = chain.get(chain.size() - 1);
        for (int i = chain.size() - 2; i >= 0; i--) {
            node.prev = chain.get(i);
            node.child = null;
            node = chain.get(i);
        }
        return chain.get(0);
    }


    public void dfs(LinkedNode head) {
        if (head == null) {
            return;
        }
        chain.add(head);
        if (head.child != null) {
            dfs(head.child);
        }
        if (head.next != null) {
            dfs(head.next);
        }
    }
}