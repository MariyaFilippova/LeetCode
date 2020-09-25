import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimumCostForTickets {
    public int mincostTickets(int[] days, int[] costs) {
        int[] periods = new int[]{1, 7, 30};

        if (days.length == 0) {
            return 0;
        }
        int[] d = new int[days.length + 1];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;
        for (int i = 0; i < days.length; i++) {
            d[i + 1] = Math.min(d[i + 1], d[i] + costs[0]);
            for (int j = i - 1; j >= 0; j--) {
                for (int k = 1; k < 3; k++) {
                    d[i + 1] = Math.min(d[i + 1], d[i] + costs[k]);
                    if (days[i] - days[j] < periods[k]) {
                        d[i + 1] = Math.min(d[i + 1], d[j + 1] + costs[k]);
                    }
                }
            }
        }
        return d[days.length];
    }

    public static void main(String[] args) {
        new MinimumCostForTickets().mincostTickets(new int[] {1,4,6,7,8,20}, new int [] {7,2, 15});
    }
}
