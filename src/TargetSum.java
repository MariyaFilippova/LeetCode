import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class TargetSum {
    int S;
    public int findTargetSumWays(int[] nums, int S) {
        if (nums.length == 0) {
            return 0;
        }
        this.S = S;
        return dp(nums, nums.length - 1, 0);
    }

    int dp(int [] nums, int index, int sum) {
        if (index < 0 && sum == S) {
            return 1;
        }
        if (index < 0) {
            return 0;
        }
        return dp(nums, index - 1, sum + nums[index]) + dp(nums, index - 1, sum - nums[index]);
    }
}
