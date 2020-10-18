import java.util.Arrays;

public class FindValidMatrixGivenRowandColumnSums {
    int[][] matrix;

    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length;
        int m = colSum.length;
        if (n == 0 || m == 0) {
            return new int[][]{};
        }
        matrix = new int[n][m];
        for (; ;) {
            int smallestRow = getSmallest(rowSum);
            int smallestCol = getSmallest(colSum);
            if (smallestCol == -1 || smallestRow == -1) {
                return matrix;
            }
            matrix[smallestRow][smallestCol] = Math.min(rowSum[smallestRow], colSum[smallestCol]);
            rowSum[smallestRow] -= matrix[smallestRow][smallestCol];
            colSum[smallestCol] -= matrix[smallestRow][smallestCol];
        }
    }

    int getSmallest(int[] array) {
        int index = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i] && array[i] > 0) {
                index = i;
                min = array[i];
            }
        }
        return index;
    }

}
