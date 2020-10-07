public class WordSearch {
    String s;
    char[][] grid;

    public boolean exist(char[][] board, String word) {
        s = word;
        grid = board;
        int n = board.length;
        if (n == 0) {
            return false;
        }
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if(backtrack(0, i, j, n, m)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    boolean backtrack(int start, int i, int j, int n, int m) {
        if (start == s.length()) {
            return true;
        }
        if (i == -1 || i == n || j == -1 || j == m) {
            return false;
        }

        if (grid[i][j] == s.charAt(start)) {
            grid[i][j] = '*';
        }
        else {
            return false;
        }
        boolean letter = backtrack(start + 1, i + 1, j, n ,m) ||
                backtrack(start + 1, i - 1, j, n ,m) ||
                backtrack(start + 1, i, j - 1, n ,m) ||
                backtrack( start + 1, i, j + 1, n ,m);

        grid[i][j] = s.charAt(start);
        return letter;
    }

    public static void main(String[] args) {
        new WordSearch().exist(new char[][]{{'a', 'b'}, {'c', 'd'}}, "acdо");
    }
}
