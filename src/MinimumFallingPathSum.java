public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] A) {
        if (A.length == 0) {
            return 0;
        }
        int[][] d = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            d[0][i] = A[0][i];
        }
        for (int i = 1; i < A.length; i++) {
            for (int j = 0; j < A[0].length; j++) {
                if (j != 0 && j != A[0].length - 1)
                    d[i][j] = A[i][j] + Math.min(d[i-1][j], Math.min(d[i - 1][j - 1], d[i - 1][j + 1]));
                else if (j == 0){
                    d[i][j] = A[i][j] + Math.min(d[i-1][j], d[i - 1][j + 1]);
                }
                else if (j == A[0].length - 1) {
                    d[i][j] = A[i][j] + Math.min(d[i-1][j], d[i - 1][j - 1]);
                }
            }
        }
        int min = 2789119;
        for (int i = 0; i < A[0].length; i++) {
            if (d[d.length - 1][i] < min) {
                min = d[d.length - 1][i];
            }
        }
        return min;
    }
}
