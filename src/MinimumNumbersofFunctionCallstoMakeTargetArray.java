public class MinimumNumbersofFunctionCallstoMakeTargetArray {
    public int minOperations(int[] nums) {
        int ops = 0;
        int counter = 0;
        while (true) {
            counter = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 != 0) {
                    nums[i]--;
                    ops++;
                }
                nums[i] = nums[i] / 2;
                if (nums[i] != 0) {
                    counter++;
                }
            }
            if (counter == 0) {
                return ops;
            }
            ops++;
        }
    }
}
