import java.util.Arrays;

public class KnightProbabilityinChessboard {
    int N;
    public double knightProbability(int N, int K, int r, int c) {
        this.N = N;
        Double [][][] memo = new Double[N][N][K];

        return (double) dfs(r, c, K, memo) / (double) Math.pow(8, K);
    }

    Double dfs(int i, int j, int K, Double[][][] memo) {
        if (i <= -1 || j <= -1 || i >= N || j >= N) {
            return (double) 0;
        }
        if (K == 0) {
            return (double) 1;
        }
        if (memo[i][j][K-1] != null) {
            return memo[i][j][K-1];
        }
        memo[i][j][K-1] =  dfs(i + 2, j + 1, K - 1, memo) +
                dfs(i + 1, j + 2, K - 1, memo) +
                dfs(i - 1, j + 2, K - 1, memo) +
                dfs(i - 2, j + 1, K - 1, memo) +
                dfs(i - 2, j - 1, K - 1, memo) +
                dfs(i - 1, j - 2, K - 1, memo) +
                dfs(i + 1, j - 2, K - 1, memo) +
                dfs(i + 2, j - 1, K - 1, memo);
        return memo[i][j][K-1];
    }
}
