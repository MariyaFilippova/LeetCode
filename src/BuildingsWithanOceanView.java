import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BuildingsWithanOceanView {
    public int[] findBuildings(int[] heights) {
        List<Integer> set = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = heights.length - 1; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                set.add(i);
            }
        }
        Collections.reverse(set);
        int[] res = new int[set.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = set.get(i);
        }
        return res;
    }
}
