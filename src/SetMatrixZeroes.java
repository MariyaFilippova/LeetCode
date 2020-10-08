import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        List<int []> zeros = new ArrayList<>();
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    zeros.add(new int[] {i, j});
                }
            }
        }
        for (int[] zero: zeros) {
            Arrays.fill(matrix[zero[0]], 0);
            for (int i = 0; i < n; i++) {
                matrix[i][zero[1]] = 0;
            }
        }
    }
}
