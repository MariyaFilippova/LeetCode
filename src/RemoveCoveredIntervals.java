import java.util.Arrays;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int r = 0;
        int counter = 0;
        for ( int i[] : intervals) {
            if (i[1] > r) {
                counter++;
            }
        }
        return counter;
    }
}
