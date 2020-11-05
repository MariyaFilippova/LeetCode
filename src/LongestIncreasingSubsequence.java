import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int max = Integer.MIN_VALUE;

    public int lengthOfLIS(int[] nums) {
        int j = 1;
        int i = 0;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        while (j < n) {
            i = 0;
            while (i < j) {
                if (nums[i] < nums[j] ) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                    max = Math.max(max, dp[j]);
                }
                i++;
            }
            j++;
        }
        return max;
    }
}
