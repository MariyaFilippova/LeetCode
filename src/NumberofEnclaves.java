public class NumberofEnclaves {
    public int numEnclaves(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        for (int k = 0; k < r; k++) {
            if (A[k][0] == 1) {
                dfs(A, k, 0);
            }
            if (A[k][c-1] == 1) {
                dfs(A, k, c-1);
            }
        }
        for (int k = 0; k < c; k++) {
            if (A[0][k] == 1) {
                dfs(A, 0, k);
            }
            if (A[r - 1][k] == 1) {
                dfs(A, r - 1, k);
            }
        }
        int counter = 0;
        for (int k = 0; k < A.length; k++) {
            for (int l = 0; l < A[0].length; l++) {
                if (A[k][l] == 1) {
                    counter++;
                }
            }
        }
        return counter;
    }

    public void dfs(int[][] A, int i, int j) {
        A[i][j] = 0;
        if (i != 0 && A[i - 1][j] == 1) {
            dfs(A, i - 1, j);
        }
        if (j != 0 && A[i][j - 1] == 1) {
            dfs(A, i, j - 1);
        }
        if (i != A.length - 1 && A[i + 1][j] == 1) {
            dfs(A, i + 1, j);
        }
        if (j != A[0].length - 1 && A[i][j + 1] == 1) {
            dfs(A, i, j + 1);
        }
    }
}
