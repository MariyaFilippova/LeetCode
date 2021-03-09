import java.util.Map;
import java.util.TreeMap;

public class DivideArrayinSetsofKConsecutiveNumbers {
    public boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length == 0) {
            return false;
        }
        if (nums.length % k != 0) {
            return false;
        }
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) > 0) {
                for (int i = k - 1; i >=0; i--) {
                    if (map.getOrDefault(key + i, 0) < map.get(key)) {
                        return false;
                    }
                    map.put(key + i, map.get(key + i) - map.get(key));
                }
            }
        }
        return true;
    }
}
