public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int local_max = 0;
        int max = 0;
        for (int i: nums) {
            max = Math.max(max, local_max = i == 0 ? 0 : local_max + 1);
        }
        return max;
    }
}
