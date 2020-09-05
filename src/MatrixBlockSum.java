import static java.lang.Math.min;
import static java.lang.Math.max;

public class MatrixBlockSum {
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int [][] d = new int[mat.length + 1][mat[0].length + 1];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                d[i + 1][j + 1] = mat[i][j] + d[i][j + 1] + d[i + 1][j] - d[i][j];
            }
        }
        int [][] res = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int rr = min(i + K + 1, mat.length);
                int rl = max(i - K, 0);
                int cu = max(j - K, 0);
                int cd = min(j + K + 1, mat[0].length);
                res[i][j] = d[rr][cd] + d[rl][cu] - d[rr][cu] - d[rl][cd];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        new MatrixBlockSum().matrixBlockSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}}, 2);
    }
}
