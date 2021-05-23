import java.util.PriorityQueue;

public class MinimumCosttoConnectSticks {
    public int connectSticks(int[] sticks) {
        if (sticks.length == 1) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int stick : sticks) {
            queue.add(stick);
        }
        int res = 0;
        while (queue.size() != 2) {
            int q = queue.poll();
            int r = queue.poll();
            res += q + r;
            queue.add(q + r);
        }
        res += queue.poll() + queue.poll();
        return res;
    }
}
