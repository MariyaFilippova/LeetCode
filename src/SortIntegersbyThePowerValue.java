import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SortIntegersbyThePowerValue {
    Map<Integer, Integer> map = new HashMap<>();

    public int getKth(int lo, int hi, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] != a[1] ? a[1] - b[1] : a[0] - b[0]);
        map.put(1, 0);
        for (int i = lo; i <= hi; i++) {
            q.add(new int[]{i, power(i)});
        }
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (!q.isEmpty()) {
                res = q.poll()[0];
            }
        }
        return res;
    }

    public int power(int i) {
        if (i == 1) {
            return 0;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        } else {
            if (i % 2 == 0) {
                map.put(i, power(i / 2) + 1);
            } else {
                map.put(i, power(i * 3 + 1) + 1);
            }
        }
        return map.get(i);
    }
}
