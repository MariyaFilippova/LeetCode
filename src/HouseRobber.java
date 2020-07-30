public class HouseRobber {
    public int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[][] d = new int[2][nums.length];
        d[0][0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            d[0][i] = d[1][i - 1] + nums[i];
            d[1][i] = Math.max(d[1][i - 1], d[0][i - 1]);
        }
        return Math.max(d[0][nums.length - 1], d[1][nums.length - 1]);
    }
}
