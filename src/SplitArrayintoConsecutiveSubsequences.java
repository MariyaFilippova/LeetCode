import java.util.HashMap;
import java.util.Map;

public class SplitArrayintoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> starts = new HashMap<>();
        Map<Integer, Integer> ends = new HashMap<>();
        for (int i: nums) {
            starts.put(i, starts.getOrDefault(i, 0) + 1);
        }
        for (int i: nums) {
            if (starts.get(i) == 0) {
                continue;
            }
            starts.put(i, starts.get(i) - 1);
            if (ends.getOrDefault(i - 1, 0) > 0) {
                ends.put(i - 1, ends.get(i - 1) - 1);
                ends.put(i, ends.getOrDefault(i, 0) + 1);
            }
            else {
                if (starts.getOrDefault(i + 1, 0) > 0 && starts.getOrDefault(i + 2, 0) > 0) {
                    starts.put(i + 1, starts.get(i + 1) - 1);
                    starts.put(i + 2, starts.get(i + 2) - 1);
                    ends.put(i + 2, ends.getOrDefault(i + 2, 0) + 1);
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}
