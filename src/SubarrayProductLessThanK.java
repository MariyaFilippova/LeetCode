public class SubarrayProductLessThanK {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int l = 0;
        int res = 0;
        int product = 1;
        if (k <= 1) return 0;
        for (int r = 0; r < nums.length; r++) {
            product *= nums[r];
            while (product >= k) {
                product /= nums[l++];
            }
            res += r - l + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        new SubarrayProductLessThanK().numSubarrayProductLessThanK(new int[]{10,5,2,6},
        100);
    }
}
