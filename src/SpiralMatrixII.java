public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        if (n == 0) {
            return new int[][]{};
        }
        int[][] matrix = new int[n][n];
        int left = 0;
        int right = n - 1;
        int top = 0;
        int bottom = n - 1;
        int number = 1;
        while (left <= right) {
            for (int i = left; i <= right; i++) {
                matrix[top][i] = number++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = number++;
            }
            right--;
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = number++;
            }
            bottom--;
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = number++;
            }
            left++;
        }
        return matrix;
    }
}
