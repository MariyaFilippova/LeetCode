import java.util.Arrays;

public class OutofBoundaryPaths {
    int M = 1000000007;

    public int findPaths(int m, int n, int N, int i, int j) {
        if (N == 0) {
            return 0;
        }
        int[][][] memo = new int[m][n][N + 1];
        for (int x = 0; x < memo.length; x++) {
            for (int y = 0; y < memo[0].length; y++) {
                Arrays.fill(memo[x][y], -1);
            }
        }
        return dfs(i, j, m, n, memo, N);
    }

    int dfs(int i, int j, int m, int n, int[][][] memo, int N) {
        if (i == -1 || i == m || j == -1 || j == n) {
            return 1;
        }
        if (N == 0) {
            return 0;
        }
        if (memo[i][j][N] >= 0) {
            return memo[i][j][N];
        }
        memo[i][j][N] = ((dfs(i + 1, j, m, n, memo, N - 1) + dfs(i - 1, j, m, n, memo, N - 1)) % M + (dfs(i, j + 1, m, n, memo, N - 1) + dfs(i, j - 1, m, n, memo, N - 1)) % M) % M;
        return memo[i][j][N];
    }


}
