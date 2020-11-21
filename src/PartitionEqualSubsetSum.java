public class PartitionEqualSubsetSum {
    int total = 0;

    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }
        for (int num : nums) {
            total += num;
        }
        if (total % 2 != 0) {
            return false;
        }
        boolean[] dp = new boolean[total / 2 + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = total / 2; j >= nums[i]; j--) {
                dp[j] |= dp[j - nums[i]];
            }
        }
        return dp[total / 2];
    }
}
