import java.util.ArrayList;
import java.util.List;

public class SurroundedRegions {
    int flag;
    public void solve(char[][] board) {
        int n = board.length;
        if (n == 0) {
            return;
        }
        int m = board[0].length;
        int[][] visited = new int[n][m];
        List<int []> coordinates = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    dfs(board, i, j, coordinates, visited);
                    if (flag == 0) {
                        for (int [] cell : coordinates) {
                            board[cell[0]][cell[1]] = 'X';
                        }
                    }
                    flag = 0;
                    coordinates.clear();
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j, List<int []> coordinates, int[][] visited) {
        if (board[i][j] == 'O') {
            if (visited[i][j] == 2) {
                flag = 1;
                return;
            }
            if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
                flag = 1;
            }
            if (visited[i][j] == 0){
                visited[i][j] = 1;
            }
            coordinates.add(new int [] {i, j});
            if (i != 0 && visited[i - 1][j] != 1)
                dfs(board, i - 1, j, coordinates, visited);
            if (i != board.length - 1 && visited[i + 1][j] != 1)
                dfs(board, i + 1, j, coordinates, visited);
            if (j != 0 && visited[i][j - 1] != 1)
                dfs(board, i, j - 1, coordinates, visited);
            if (j != board[0].length - 1 && visited[i][j + 1] != 1)
                dfs(board, i, j + 1, coordinates, visited);
        }
    }

    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][] {{'O','O','X','O','O'},{'O','X','O','O','O'}});
    }
}
