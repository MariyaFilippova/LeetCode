public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int[] result = new int[2];
        int n = nums.length;
        int[] counters = new int[n];
        for (int i: nums) {
            if (++counters[i-1] == 2) {
                result[0] = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (counters[i] == 0) {
                result[1] = i+1;
            }
        }
        return result;
    }
}
