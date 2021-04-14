import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumJumpstoReachHome {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int max = x + a + b;
        int steps = 0;
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        Set<Pair<Integer, Integer>> used = new HashSet<>();
        for (int i : forbidden) {
            used.add(new Pair<>(0, i));
            used.add(new Pair<>(1, i));
            max = Math.max(max, i + a + b);
        }
        used.add(new Pair<>(0, 0));
        queue.add(new Pair<>(0, 0));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size != 0) {
                Pair<Integer, Integer> pair = queue.poll();
                if (pair.getValue() == x) {
                    return steps;
                }
                int key = pair.getKey();
                int val = pair.getValue();

                Pair<Integer, Integer> forward = new Pair<>(0, val + a);
                Pair<Integer, Integer> back = new Pair<>(1, val - b);
                if (used.add(forward) && max >= val + a) {
                    queue.offer(forward);
                }
                if (key == 0 && used.add(back) && val - b >= 0) {
                    queue.offer(back);
                }
                size--;
            }
            steps++;
        }
        return -1;
    }
}
