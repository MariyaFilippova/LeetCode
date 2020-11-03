public class TextJustification {
    int inf = Integer.MAX_VALUE;

    public String fullJustify(String[] words, int maxWidth) {
        int n = words.length;
        if (n == 0) {
            return null;
        }
        int[][] d = new int[n][n];
        int length = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                length = 0;
                for (int k = i; k <= j; k++) {
                    length += words[k].length();
                }
                length += j - i;
                if (length > maxWidth) {
                    d[i][j] = inf;
                } else {
                    d[i][j] = (maxWidth - length) * (maxWidth - length);
                }
            }
        }
        int[] minCost = new int[n];
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            minCost[i] = d[i][n - 1];
            result[i] = n;
            for (int j = n - 1; j > i; j--) {
                if (d[i][j - 1] == inf) {
                    continue;
                }
                if (minCost[i] > minCost[j] + d[i][j - 1]) {
                    minCost[i] = minCost[j] + d[i][j - 1];
                    result[i] = j;
                }
            }
        }

        StringBuilder res = new StringBuilder();
        int i = 0;
        int j = 0;
        while (true) {
            for (j = i; j < result[i]; j++) {
                if (j != i) {
                    res.append(" ");
                }
                res.append(words[j]);
            }
            i = result[i];
            if (i == n) {
                break;
            }
            res.append("\n");
        }
        return res.toString();
    }
}
