import java.util.*;

/**
 * Your LockingTree object will be instantiated and called as such:
 * LockingTree obj = new LockingTree(parent);
 * boolean param_1 = obj.lock(num,user);
 * boolean param_2 = obj.unlock(num,user);
 * boolean param_3 = obj.upgrade(num,user);
 */

public class LockingTree {
    int [] parent;
    int [] locked;
    Map<Integer, List<Integer>> children = new HashMap<>();

    public LockingTree(int[] parent) {
        locked = new int[parent.length];
        Arrays.fill(locked, -1);
        this.parent = parent;
        for (int i = 0; i < parent.length; i++) {
            int par = parent[i];
            if (par != -1) {
                List<Integer> list = children.getOrDefault(par, new ArrayList<>());
                list.add(i);
                children.put(par, list);
            }
        }
    }

    public boolean lock(int num, int user) {
        if (locked[num] != -1) {
            return false;
        }
        locked[num] = user;
        return true;
    }

    public boolean unlock(int num, int user) {
        if (locked[num] != user) {
            return false;
        }
        locked[num] = -1;
        return true;
    }

    public boolean upgrade(int num, int user) {
        if (locked[num] != -1) return false;
        if (parentsNotLocked(num) && childLocked(num)) {
            locked[num] = user;
            return true;
        }
        return false;
    }

    private boolean parentsNotLocked(int num) {
        int par = parent[num];
        while (par != -1) {
            if (locked[par] != -1) return false;
            par = parent[par];
        }
        return true;
    }

    private boolean childLocked(int num) {
        boolean childLocked = false;
        if (!children.containsKey(num)) return false;
        Queue<Integer> queue = new LinkedList<>(children.get(num));
        while (!queue.isEmpty()) {
            int i = queue.poll();
            if (locked[i] != -1) {
                locked[i] = -1;
                childLocked = true;
            }
            if (children.containsKey(i)) {
                queue.addAll(children.get(i));
            }
        }
        return childLocked;
    }

    public static void main(String[] args) {
        LockingTree tree = new LockingTree(new int[] {-1,0,3,1,0});
        tree.upgrade(4, 5);

    }
}
