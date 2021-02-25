public class SumofUniqueElements {

    public int sumOfUnique(int[] nums) {
        int[] freq = new int[101];
        for (int i : nums) {
            freq[i]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 1) {
                freq[0] += i;
            }
        }
        return freq[0];
    }
}
