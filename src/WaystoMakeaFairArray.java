public class WaystoMakeaFairArray {
    public int waysToMakeFair(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[] prefixSum = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i] = i > 1 ? prefixSum[i - 2] + nums[i] : nums[i];
        }
        int ways = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                int prevOdd = i != 0 ? prefixSum[i - 1] : 0;
                int postOdd = prefixSum[(nums.length) % 2 == 1 ? nums.length - 1 : nums.length - 2] - prefixSum[i];
                int prevEven = prefixSum[i] - nums[i];
                int postEven = prefixSum[(nums.length) % 2 == 1 ? nums.length - 2 : nums.length - 1] - (i == 0 ? 0 : prefixSum[i - 1]);
                if (prevOdd + postOdd == prevEven + postEven) {
                    ways++;
                }
            } else {
                int prevEven = prefixSum[i - 1];
                int postEven = prefixSum[(nums.length) % 2 == 1 ? nums.length - 2 : nums.length - 1] - prefixSum[i];
                int prevOdd = prefixSum[i] - nums[i];
                int postOdd = prefixSum[(nums.length) % 2 == 1 ? nums.length - 1 : nums.length - 2] - prefixSum[i - 1];
                if (prevOdd + postOdd == prevEven + postEven) {
                    ways++;
                }
            }
        }
        return ways;
    }
}
