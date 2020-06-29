import java.util.ArrayList;
import java.util.List;

public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            path[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            path[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i ][j] = path[i - 1][j] + path[i][j - 1];
            }
        }
        return path[m-1][n-1];
    }

    public static void main(String[] args) {
        new UniquePaths().uniquePaths(3, 2);
    }
}
