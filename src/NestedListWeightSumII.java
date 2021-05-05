import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSumII {
    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<int[]> list = new ArrayList<>();
        int depth = 0;
        int res = 0;
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                NestedInteger value = queue.poll();
                if (value.isInteger()) {
                    list.add(new int[]{value.getInteger(), depth + 1});
                } else {
                    queue.addAll(value.getList());
                }
                size--;
            }
            depth++;
        }
        for (int[] value : list) {
            res += (depth - value[1] + 1) * value[0];
        }
        return res;
    }
}
