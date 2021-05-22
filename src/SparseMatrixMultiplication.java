public class SparseMatrixMultiplication {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int u = 0; u < m; u++) {
                int product = 0;
                for (int j = 0; j < k; j++) {
                    product += mat1[i][j] * mat2[j][u];
                }
                res[i][u] = product;
            }
        }
        return res;
    }
}
