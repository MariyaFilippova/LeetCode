public class MaximumNonNegativeProductinaMatrix {
    public int maxProductPath(int[][] grid) {
        int mod = 1_000_000_007;
        int n = grid.length;
        if (n == 0) {
            return 0;
        }
        int m = grid[0].length;
        long[][][] d = new long[n][m][2];
        d[0][0][0] = grid[0][0];
        d[0][0][1] = grid[0][0];
        for (int i = 1; i < n; i++) {
            d[i][0][0] = d[i][0][1] = d[i - 1][0][0] * grid[i][0];
        }
        for (int j = 1; j < m; j++) {
            d[0][j][0] = d[0][j][1] = d[0][j - 1][0] * grid[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                long a = Math.max(d[i - 1][j][0], d[i][j - 1][0]) * grid[i][j];
                long b = Math.min(d[i - 1][j][1], d[i][j - 1][1]) * grid[i][j];
                d[i][j][0] = Math.max(a, b);
                d[i][j][1] = Math.min(a, b);
            }
        }
        if (d[n - 1][m - 1][0] < 0) {
            return -1;
        }
        return (int)(d[n - 1][m - 1][0] % mod);
    }

    public static void main(String[] args) {
        new MaximumNonNegativeProductinaMatrix().maxProductPath(new int[][]{{4, 3}});
    }
}
