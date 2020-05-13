public class ClimbingStairs {
    public int climbStairs(int n) {
        if ( n == 1) {
            return 1;
        }
        int[] d = new int[n];
        d[0] = 1;
        d[1] = 2;
        for (int i = 2; i < n; i++) {
            d[i] = d[i - 1] + d[i - 2];
        }
        return d[n-1];
    }
}
