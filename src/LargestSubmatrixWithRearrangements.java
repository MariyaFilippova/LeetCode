import java.util.Arrays;

public class LargestSubmatrixWithRearrangements {
    public int largestSubmatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) {
                    matrix[i][j] += matrix[i - 1][j];
                }
            }
        }
        int res = 0;
        for (int i = 0; i < matrix.length; i++) {
            Arrays.sort(matrix[i]);
            for (int j = 0; j < matrix[i].length; j++) {
                res = Math.max(res, matrix[i][j] * (matrix[i].length - j ));
            }
        }
        return res;
    }
}
