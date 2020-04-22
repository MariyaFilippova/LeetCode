import java.util.Scanner;

public class NumberOfIlands {
    public int numIslands(char[][] grid) {
        int counter = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    counter++;
                    dfs(i, j, grid, n, m);
                }
            }
        }
        return counter;
    }

    public void dfs(int i, int j, char[][] grid, int n, int m) {
        if ((i < 0) || i >= n || j >= m || j < 0 || grid[i][j] == '1') {
            return;
        }
        grid[i][j] = '0';
        dfs(i - 1, j, grid, n, m);
        dfs(i, j - 1, grid, n, m);
        dfs(i + 1, j, grid, n, m);
        dfs(i, j + 1, grid, n, m);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        char[][] grid = new char[n][m];
        int o = 0;
        String s = scanner.next();
        for (int i = 0; i<n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(o);
                o++;
            }
        }
        new NumberOfIlands().numIslands(grid);
    }

}
