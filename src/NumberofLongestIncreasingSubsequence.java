import java.util.Arrays;

public class NumberofLongestIncreasingSubsequence {
    int max = 1;
    int number = 0;

    public int findNumberOfLIS(int[] nums) {
        int j = 1;
        int i = 0;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n];
        int[] numberOfIncrSubs = new int[n];
        Arrays.fill(numberOfIncrSubs, 1);
        Arrays.fill(dp, 1);
        while (j < n) {
            i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    if (dp[j] == dp[i] + 1) {
                        numberOfIncrSubs[j] += numberOfIncrSubs[i];
                    }
                    else if (dp[j] < dp[i] + 1) {
                        numberOfIncrSubs[j] = numberOfIncrSubs[i];
                    }
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                    max = Math.max(dp[j], max);
                }
                i++;
            }
            j++;
        }
        for (int k = 0; k < n; k++) {
            if (dp[k] == max) {
                number += numberOfIncrSubs[k];
            }
        }
        return number;
    }
}
