import java.util.Scanner;

public class CountServersthatCommunicate {
    public int countServers(int[][] grid) {
        int counter = 0;
        int n = grid.length;
        int m = grid[0].length;
        int[] string = new int[n];
        int[] column = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m;j++) {
                if (grid[i][j] == 1) {
                    string[i]++;
                    column[j]++;
                    counter++;
                }
            }
        }
        int temp = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (column[j] == 1 && string[i] == 1 && grid[i][j] == 1) {
                    temp++;
                }
            }
        }
        return counter - temp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }
        new CountServersthatCommunicate().countServers(grid);
    }
}
