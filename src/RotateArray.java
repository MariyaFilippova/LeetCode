public class RotateArray {
    public void rotate(int[] nums, int k) {
        if (nums.length <= 1 || k == 0) return;
        int i = 0;
        int realRotations = k % nums.length;
        int pointerRotated = nums.length - realRotations;
        int j = pointerRotated;
        int m = 0;
        int[] res = new int[nums.length];
        while (j < nums.length) {
            res[m] = nums[j];
            j++;
            m++;
        }
        while (i < pointerRotated) {
            res[m] = nums[i];
            i++;
            m++;
        }
        for (i = 0; i < nums.length; i++) {
            nums[i] = res[i];
        }
    }
}
