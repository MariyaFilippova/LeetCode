import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
        ArrayList<int[]> res = new ArrayList<>();
        res.add(intervals[0]);
        int j = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][1] > res.get(j)[1] && intervals[i][0] <= res.get(j)[1]) {
                intervals[i][0] = res.get(j)[0];
                res.remove(j);
                res.add(intervals[i]);
            }
            if (intervals[i][1] <= res.get(j)[1])
            {
                continue;
            }
            else {
                res.add(intervals[i]);
                j++;
            }
        }
        int[][] result = new int[res.size()][2];
        for (int i = 0; i< res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }
}
