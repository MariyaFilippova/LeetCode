import java.util.HashSet;
import java.util.Set;

public class PerfectSquares {
    public int numSquares(int n) {
        int counter = 0;
        int[] d = new int[n+1];
        for (int i = 1; i <= n; i++) {
            d[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; i >= j*j; j++) {
                d[i] = Math.min(1 + d[i - j*j], d[i]);
            }
        }
        return d[n];
    }
}
