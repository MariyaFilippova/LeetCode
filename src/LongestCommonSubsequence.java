public class LongestCommonSubsequence {
    int d[][];
    String text1;
    String text2;
    int n;
    int m;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1 = text1;
        this.text2 = text2;

        n = text1.length();
        m = text2.length();
        if (m == 0 || n == 0) {
            return 0;
        }

        d = new int[n + 1][m + 1];
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

    public StringBuilder getRes() {
        StringBuilder res = new StringBuilder();
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                res.append(text1.charAt(i - 1));
                i--;
                j--;
                continue;
            }
            else {
                if (d[i - 1][j] > d[i][j - 1]) {
                    i--;
                }
                else {
                    j--;
                }
            }
        }
        return res.reverse();
     }

    public static void main(String[] args) {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        lcs.longestCommonSubsequence("abcde", "ace");
        lcs.getRes();
    }
}
