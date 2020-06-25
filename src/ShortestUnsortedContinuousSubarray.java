public class ShortestUnsortedContinuousSubarray {
    public int findUnsortedSubarray(int[] nums) {
        int counter = 0;
        int res = 0;
        boolean flag = false;
        int i = 0;
        int k = 0;
        for (i = 0; i < nums.length; i++) {
            if (flag) {
                flag = false;
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] <= nums[j]) {
                    counter++;
                }
                else {
                    flag = true;
                    break;
                }
            }
            if (counter == nums.length - i - 1) {
                res++;
            }
            counter = 0;
        }
        if (i == nums.length - 1) {
            return nums.length - res;
        }
        for (k = nums.length - 1; k > i; k--) {
            if (flag) {
                break;
            }
            for (int j = k - 1; j >= 0; j--) {
                if (nums[k] >= nums[j]) {
                    counter++;
                }
                else {
                    flag = true;
                    break;
                }
            }
            if (counter == k) {
                res++;
            }
            counter = 0;
        }
        return nums.length - res;
    }

    public static void main(String[] args) {
        new ShortestUnsortedContinuousSubarray().findUnsortedSubarray(new int[] {2,6,4,8,10,9,15});
    }
}
