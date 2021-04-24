import java.util.HashMap;
import java.util.Map;

public class TuplewithSameProduct {
    public int tupleSameProduct(int[] nums) {
        int counter = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i != j)
                    map.put(nums[i] * nums[j], map.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freq > 1) {
                counter += freq * (freq - 2);
            }
        }
        return counter;
    }
}
