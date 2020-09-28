import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReduceArraySizetoTheHalf {
    Map<Integer, Integer> map = new HashMap<>();

    public int minSetSize(int[] arr) {
        List[] freq = new ArrayList[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        for (int num : map.keySet()) {
            int count = map.get(num);
            if (freq[count] == null) {
                freq[count] = new ArrayList<Integer>();
            }
            freq[count].add(num);
        }

        int res = 0;
        int reduced = 0;
        for (int i = arr.length; i > 0; i--) {
            List<Integer> current = freq[i];
            if (current == null || current.size() == 0) {
                continue;
            }
            for (int num: current) {
                res++;
                reduced += i;

                if (reduced >= arr.length / 2) {
                    return res;
                }
            }
        }
        return arr.length;
    }
}
