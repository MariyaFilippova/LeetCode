public class ReshapeTheMatrix {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (r * c != n * m) return mat;
        int[][] res = new int[r][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int elements = i * m + j;
                res[elements/c][elements%c] = mat[i][j];
            }
        }
        return res;
    }
}
