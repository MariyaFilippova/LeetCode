public class MinimumDeletionstoMakeStringBalanced {
    public int minimumDeletions(String s) {
        int[] dp = new int[s.length() + 1];
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'a') {
                dp[i + 1] = Math.min(b, dp[i]);
            } else {
                b++;
                dp[i+1] = dp[i];
            }
        }
        return dp[s.length()];
    }
}
