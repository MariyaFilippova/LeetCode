public class Searcha2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row = 0;
        int col = m - 1;
        while (col >=0 && row < n && matrix[row][col] != target) {
            if (matrix[row][col] < target) {
                row++;
            }
            else if (matrix[row][col] > target) {
                col--;
            }
        }
        if (col == -1 || row == n) {
            return false;
        }
        return true;
    }
}
