import java.util.PriorityQueue;

public class MinimumDeletionCosttoAvoidRepeatingLetters {
    public int minCost(String s, int[] cost) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int res = 0;
        int i = 0;
        while (i < n - 1) {
            while (i < n - 1 && s.charAt(i) == s.charAt(i + 1)) {
                queue.add(cost[i]);
                i++;
            }
            if (i == n) {
                return res;
            }
            queue.add(cost[i]);
            while (queue.size() > 1) {
                res += queue.poll();
            }
            queue.clear();
            i++;
        }
        return res;
    }
}
