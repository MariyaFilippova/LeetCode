public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int h = numbers.length - 1;
        while (l < h) {
            int elmnt = numbers[l] + numbers[h];
            if (elmnt == target) {
                return new int[] {l + 1, h + 1};
            }
            else if (elmnt < target) l++;
            else h--;
        }
        return null;
    }
}
