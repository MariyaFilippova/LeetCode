public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        for (int i = 0; i < n/2; i++) {
            int [] bottom = matrix[n - i - 1];
            matrix[n - i - 1] = matrix[i];
            matrix[i] = bottom;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int bottom = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = bottom;
            }
        }
    }
}
