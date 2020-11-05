import java.util.Arrays;

public class LongestIncreasingSubsequence {
    int max = 1;
    int index = 0;

    public int lengthOfLIS(int[] nums) {
        int j = 1;
        int i = 0;
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int[] parents = new int[n];
        Arrays.fill(parents, -1);
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        while (j < n) {
            i = 0;
            while (i < j) {
                if (nums[i] < nums[j]) {
                    dp[j] = Math.max(dp[i] + 1, dp[j]);
                    if (max < dp[j]) {
                        max = dp[j];
                        index = j;
                    }
                    parents[j] = i;
                }
                i++;
            }
            j++;
        }
        int[] res = new int[max];
        int k = max - 1;
        do {
            res[k] = nums[index];
            index = parents[index];
            k--;
        } while (index != -1);
        return max;
    }
}
