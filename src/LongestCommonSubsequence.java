public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        int[][] d = new int[n + 1][m + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                }
                else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }
        return d[n][m];
    }

    public static void main(String[] args) {
        new LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace");
    }
}
