public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int len = Integer.MAX_VALUE;
        int l = 0;
        int r = 0;
        while (l <= r) {
            if (sum < target) {
                if (r < nums.length) {
                    sum += nums[r];
                    r++;
                }
                else {
                    break;
                }
            }
            else {
                len = Math.min(len, r - l);
                sum -= nums[l++];
            }
        }
        return len == Integer.MAX_VALUE ? 0 : len;
    }
}