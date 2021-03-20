import java.util.Arrays;

public class MaximumAbsoluteSumofAnySubarray {
    public int maxAbsoluteSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = Math.max(sum[i] + nums[i], nums[i]);
            max = Math.max(sum[i + 1], max);
        }
        int min = Integer.MAX_VALUE;
        Arrays.fill(sum, 0);
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = Math.min(sum[i] + nums[i], nums[i]);
            min = Math.min(sum[i + 1], min);
        }
        return Math.max(Math.abs(max), Math.abs(min));
    }
}
