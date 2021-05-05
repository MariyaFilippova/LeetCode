import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
        int depth = 1;
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                NestedInteger value = queue.poll();
                if (value.isInteger()) {
                    res += depth*value.getInteger();
                }
                else {
                    queue.addAll(value.getList());
                }
                size--;
            }
            depth++;
        }
        return res;
    }
}


// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
abstract class NestedInteger {
    // Constructor initializes an empty nested list.
    public NestedInteger() {

    }

    // Constructor initializes a single integer.
    public NestedInteger(int value) {

    }

    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public abstract boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public abstract Integer getInteger();

    // Set this NestedInteger to hold a single integer.
    public abstract void setInteger(int value);

    // Set this NestedInteger to hold a nested list and adds a nested integer to it.
    public abstract void add(NestedInteger ni);

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return empty list if this NestedInteger holds a single integer
    public abstract List<NestedInteger> getList();
}
